package com.tianbao.points.core.service.impl;


import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IUserDao;
import com.tianbao.points.core.dto.PositionDTO;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.entity.*;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.*;
import com.tianbao.points.core.utils.BeanHelper;
import com.tianbao.points.core.utils.MD5;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc 用户服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {
    /**
     * 注入用户服务dao
     */
    private final IUserDao iUserDao;
    /**
     * 注入职位服务service
     */
    private final IPositionService positionServer;
    /**
     * 注入用户职位服务service
     */
    private final IUserPositionService userPositionServer;
    /**
     * 注入角色服务service
     */
    private final IRoleService roleServer;
    /**
     * 注入用户角色关联服务service
     */
    private final IUserRoleService userRoleServer;
    /**
     * 注入会员等级service
     */
    private final IRankService rankServer;
    /**
     * 注入个人积分service
     */
    private final IPersonalBonusService personalBonusServer;

    @Value("${password.encrypt.key}")
    private String PASSWORD_SECRET_KEY;
    @Value("${super.admin.role.id}")
    private String SUPER_ADMIN_ROLE_ID;
    @Value("${reset.member.password}")
    private String MEMBER_COMMON_PASSWORD;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取管理员的个人档案资料，包装了职位和角色信息
     * 角色和用户的关系是一对多关系，一个角色对应着多个用户
     * 角色和权限的关系是多对多关系。即一个角色有着多种权限，
     * 同样，一个权限可以分给不同角色。
     * @return 返回查询数据
     * @update
     */
    @Override
    public UserDTO getPersonalInfo(Long id) throws ApplicationException {
        UserDTO userDTO = new UserDTO();
        //获取用户基本信息
        User user = iUserDao.selectByPrimaryKey(id);
        if(user == null) {
            return userDTO;
        }
        BeanHelper.copyProperties(userDTO, user);
        //根据管理员id获取相关职位信息
        List<PositionDTO> positionDTOList = positionServer.getListByUserId(id);
        userDTO.setPositionDTOList(positionDTOList);
        //根据用户id获取用户角色信息
        List<Role> roleList = roleServer.getListByUserId(id);
        userDTO.setRoleList(roleList);
        //获取会员等级
        Rank rank = rankServer.selectById(user.getRankId());
        userDTO.setRank(rank);
        return userDTO;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的登录密码，这里不是指超级密码
     * @param currentId 当前用户id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @param sureNewPassword 确认新密码
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @Transactional
    @Override
    public void updatePassword(Long currentId, String oldPassword, String newPassword, String sureNewPassword) throws ApplicationException {
        //修改普通密码的操作operation值为0
        checkPassword(currentId, oldPassword, newPassword, sureNewPassword, 0);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的超级密码，这个用户只有一个，顶级管理员，所以要先判断身份
     * @param currentId 当前用户id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @param sureNewPassword 确认新密码
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @Transactional
    @Override
    public void updateSuperPassword(Long currentId, String oldPassword, String newPassword, String sureNewPassword) throws ApplicationException {

        //查看角色是否为超级管理员
        List<Role> roleList = roleServer.getListByUserId(currentId);
        List<Long> roleIds = new ArrayList<>();
        for(Role role: roleList) {
            roleIds.add(role.getId());
        }
        if(! roleIds.contains(Long.parseLong(SUPER_ADMIN_ROLE_ID))) {
            throw new ApplicationException(1, "");
        }
        //修改超级密码的操作operation值为1
        checkPassword(currentId, oldPassword, newPassword, sureNewPassword, 1);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 根据不同type值区别不同更改密码操作，将代码块提取一个方法
     * @param currentId 当前用户id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @param sureNewPassword 确认新密码
     * @param operation 0表示更改普通密码，1表示更改超级密码
     * @return 无返回值
     * @update
     */
    private void checkPassword(Long currentId, String oldPassword, String newPassword,
                               String sureNewPassword, Integer operation)throws ApplicationException {
        if(! newPassword.equals(sureNewPassword)) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "新密码与确认密码不同");
        }
        if(oldPassword.equals(newPassword)) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "原密码与新密码相同，请输入不同的新密码");
        }
        //byte[] encoded = DES.encrypt(PASSWORD_SECRET_KEY.getBytes(), oldPassword.getBytes());
        String encodedPassword = null;
        try {
            encodedPassword = MD5.EncoderByMd5(oldPassword + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "原密码加密错误");
        }
        User user = iUserDao.selectByPrimaryKey(currentId);
        if(operation == 0) {
            if(user == null || ! encodedPassword.equals(user.getPassword())) {
                throw new ApplicationException(1, "");
            }
        }else {
            //超级密码
            if(user == null || ! encodedPassword.equals(user.getSuperPassword())) {
                throw new ApplicationException(1, "");
            }
        }
        try {
            encodedPassword = MD5.EncoderByMd5(newPassword + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "密码加密错误");
        }
        if(operation == 0) {
            user.setPassword(encodedPassword);
        }else {
            user.setSuperPassword(encodedPassword);
        }
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        iUserDao.updateByPrimaryKey(user);
    }
    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 根据用户id集合查询用户列表,分页实现，用于个人积分增值属性
     * @return 返回查询数据列表
     * @update
     */
    @Override
    public List<User> getListByIds(List<Long> ids) throws ApplicationException {
        List<User> userList = iUserDao.getListByIds(ids);
        return userList;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取所有合法用户列表，不分页
     * @return 返回查询到的数据列表
     * @update
     */
    @Override
    public List<UserDTO> getList() throws ApplicationException {
        List<User> userList = iUserDao.getList();
        List<Rank> rankList = rankServer.getList();
        List<UserDTO> userDTOList = copyRankProperties(userList, rankList);
        return userDTOList;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取所有合法用户列表，分页
     * @param pageNo 表示当前页码
     * @param pageSize 表示数据条数
     * @return 返回查询到的数据列表
     * @update
     */
    @Override
    public PageInfo<UserDTO> getListPage(Integer pageNo, Integer pageSize) throws ApplicationException {
        Page page = PageHelper.startPage(pageNo, pageSize);
        List<User> userList = iUserDao.selectListPage();
        if(userList == null || userList.size() <= 0) {
            throw new ApplicationException(ApplicationException.USER_NOT_EXISTS, "已审核用户列表为空");
        }
        List<Rank> rankList = rankServer.getList();
        List<UserDTO> userDTOList = copyRankProperties(userList, rankList);
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userDTOList);
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 拷贝等级属性到用户实体中
     * @return 返回查询到的数据列表
     * @update
     */
    private List<UserDTO> copyRankProperties(List<User> userList, List<Rank> rankList) throws ApplicationException{
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user: userList) {
            UserDTO userDTO = new UserDTO();
            BeanHelper.copyProperties(userDTO, user);
            for(Rank rank: rankList) {
                if(rank.getId().equals(user.getRankId())) {
                    userDTO.setRank(rank);
                    break;
                }
            }
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 通过会员id查询会员信息
     * @param id 输入的会员id
     * @return 返回会员实体信息
     * @update
     */
    @Override
    public UserDTO getById(Long id) throws ApplicationException {
        User user = iUserDao.selectByPrimaryKey(id);
        if(user == null) {
            throw new ApplicationException(1, "查询的会员实体不存在");
        }
        Rank rank = rankServer.selectById(user.getRankId());
        UserDTO userDTO = new UserDTO();
        BeanHelper.copyProperties(userDTO, user);
        userDTO.setRank(rank);
        return userDTO;
    }

    /**
     * @desc 根据会员id重置会员密码，设置为一个通用值
     * @author lushusheng 2018-12-02
     * @param id 会员id
     * @param currentId 当前用户id
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    @Override
    public void resetPassword(Long id, Long currentId) throws ApplicationException {
        User user = iUserDao.selectByPrimaryKey(id);
        if(user == null) {
            throw new ApplicationException(1, "查询的会员实体不存在");
        }
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        try {
            String commonPassword = MD5.EncoderByMd5(MEMBER_COMMON_PASSWORD + PASSWORD_SECRET_KEY);
            user.setPassword(commonPassword);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(1, "设置通用密码发生加密错误");
        }
        //byte[] encoded = DES.encrypt(PASSWORD_SECRET_KEY.getBytes(), MEMBER_COMMON_PASSWORD.getBytes());
        //String commonPassword = new String(encoded);
        iUserDao.updateByPrimaryKey(user);
    }

    /**
     * @desc 按条件查询会员
     * @author lushusheng 2018-12-02
     * @param type 按照何种方式进行查询：0表示按照会员id
     * 1表示按照联系方式（手机号） 2表示按照真实姓名查询
     * @param keyword 搜索关键字
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回会员信息
     * @throws ApplicationException 保存异常
     */
    @Override
    public PageInfo<UserDTO> getListByConditionPage(Integer type, String keyword, Integer pageNo, Integer pageSize) throws ApplicationException {

        PageHelper.startPage(pageNo, pageSize);
        List<User> userList = iUserDao.selectListByConditionPage(type, keyword);
        if(userList == null) {
            throw new ApplicationException(2,"");
        }
        List<Rank> rankList = rankServer.getList();
        List<UserDTO> userDTOList = copyRankProperties(userList, rankList);
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userDTOList);
        return pageInfo;
    }

    /**
     * @desc 查询管理员列表，分页展示
     * @author lushusheng 2018-12-03
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回管理员列表信息
     * @throws ApplicationException 保存异常
     */
    @Override
    public PageInfo<UserDTO> getAdminListPage(Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<User> adminList = iUserDao.getAdminListPage();
        List<UserDTO> userDTOList = new ArrayList<>();
        //后期可以优化，管理员数据量大时较慢
        for(User admin: adminList) {
            UserDTO userDTO = new UserDTO();
            BeanHelper.copyProperties(userDTO, admin);
            List<Role> roleList = roleServer.getListByUserId(admin.getId());
            List<PositionDTO> positionDTOList = positionServer.getListByUserId(admin.getId());
            userDTO.setRoleList(roleList);
            userDTO.setPositionDTOList(positionDTOList);
            userDTOList.add(userDTO);
        }
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userDTOList);
        return pageInfo;
    }
    /**
     * @desc 根据id删除特定管理员信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 实体id
     * @return 返回操作结果
     * @throws ApplicationException 删除异常
     */
    @Override
    public void deleteById(Long id, Long currentId) throws ApplicationException {
        User user = iUserDao.selectByPrimaryKey(id);
        user.setStatus(StatusCode.FORBIDDEN.getCode());
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        iUserDao.updateByPrimaryKey(user);

        //删除相关的用户角色关联
        List<UserRole> userRoleList = userRoleServer.getListByUserId(id);
        if(userRoleList != null && userRoleList.size() > 0) {
            for(UserRole userRole: userRoleList) {
                userRole.setStatus(StatusCode.FORBIDDEN.getCode());
                userRole.setUpdateTime(new Date());
                userRole.setUpdateUserId(currentId);
            }
            userRoleServer.updateBatch(userRoleList);
        }
        //删除相关的用户职位关联
        List<UserPosition> userPositionList = userPositionServer.getListByUserId(id);
        if(userPositionList != null && userPositionList.size() > 0) {
            for(UserPosition userPosition: userPositionList) {
                userPosition.setStatus(StatusCode.FORBIDDEN.getCode());
                userPosition.setUpdateTime(new Date());
                userPosition.setUpdateUserId(currentId);
            }
            userPositionServer.updateBatch(userPositionList);
        }
        //删除相关的用户个人积分
        List<PersonalBonus> personalBonusList = personalBonusServer.getPersonalListByUserId(id);
        if(personalBonusList != null && personalBonusList.size() > 0) {
            for(PersonalBonus personalBonus: personalBonusList) {
                personalBonus.setStatus(StatusCode.FORBIDDEN.getCode());
                personalBonus.setUpdateTime(new Date());
                personalBonus.setUpdateUserId(currentId);
            }
            personalBonusServer.updateBatch(personalBonusList);
        }
    }

    /**
     * @desc 保存特定管理员信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param user 保存的实体
     * @param roleId 实体参数
     * @param order 实体参数
     * @param operation 操作类型：0表示保存，1表示修改
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserDTO createNewAdmin(User user, Long roleId, Integer order, Long currentId, Integer operation) throws ApplicationException {
        if(operation == 0) {
            user.setId(IdWorker.getId());
            user.setStatus(StatusCode.NORMAL.getCode());
            user.setCreateTime(new Date());
            user.setCreateUserId(currentId);
        }
        //对密码进行加密
        String password = user.getPassword();
        String encoded = null;
        try {
            encoded = MD5.EncoderByMd5(password + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(1, "新增管理员用户密码加密错误");
        }
        //byte[] encoded = DES.encrypt(PASSWORD_SECRET_KEY.getBytes(), password.getBytes());
        //String encodedPassword = new String(encoded);
        user.setPassword(encoded);
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        //插入会员等级关联
        Rank rank = rankServer.getByOrder(order);
        user.setRankId(rank.getId());
        if(operation == 0) {
            iUserDao.insert(user);
        }else {
            iUserDao.updateByPrimaryKey(user);
        }
        //插入角色关联表
        if(operation == 1) {
            //修改，先删除以前关联的所有角色
            List<UserRole> userRoleList = userRoleServer.getListByUserId(user.getId());
            for(UserRole userRole: userRoleList) {
                userRole.setStatus(StatusCode.FORBIDDEN.getCode());
                userRole.setUpdateTime(new Date());
                userRole.setUpdateUserId(currentId);
            }
            userRoleServer.updateBatch(userRoleList);
        }
        insert(user, roleId, currentId);
        return getPersonalInfo(user.getId());
    }

    /**
     * @desc 根据会员id列表禁止会员登录，通过逻辑删除来实现
     * @author lushusheng 2018-12-12
     * @param ids 会员id输入列表
     * @param currentId 当前用户id
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void forbidBatch(List<Long> ids, Long currentId) throws ApplicationException {
        List<User> userList = iUserDao.getListByIds(ids);
        if(userList == null) {
            throw new ApplicationException(1, "查询的会员实体列表不存在");
        }
        for(User user: userList) {
            user.setStatus(StatusCode.FORBIDDEN.getCode());
            user.setUpdateTime(new Date());
            user.setUpdateUserId(currentId);
            iUserDao.updateByPrimaryKey(user);
        }
    }
    /**
     * @desc 根据会员id列表禁止会员登录，通过逻辑删除来实现
     * @author lushusheng 2018-12-12
     * @param account 会员账号
     * @return 返回查询到的会员
     * @throws ApplicationException 保存异常
     */
    @Override
    public User getByAccount(String account) throws ApplicationException {
        User user = iUserDao.getByAccount(account);
        return user;
    }

    /**
     * @desc 新建保存一条会员用户信息
     * @author lushusheng 2018-12-17
     * @param currentId 当前用户id
     * @param user 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserDTO save(User user, Long currentId) throws ApplicationException {
        user.setId(IdWorker.getId());
        user.setStatus(StatusCode.NORMAL.getCode());
        user.setCreateTime(new Date());
        user.setCreateUserId(currentId);
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        iUserDao.insert(user);
        //普通会员用户
        insert(user, new Long(4), currentId);
        return getPersonalInfo(user.getId());
    }

    /**
     * @desc 插入一条管理员信息
     * @author lushusheng 2018-12-06
     * @param currentId 当前用户id
     * @param user 保存的实体
     * @param roleId 实体参数
     * @return 返回无
     * @throws ApplicationException 保存异常
     */
    private void insert(User user, Long roleId, Long currentId)throws ApplicationException {
        UserRole userRole = new UserRole();
        userRole.setId(IdWorker.getId());
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleId);
        userRole.setStatus(StatusCode.NORMAL.getCode());
        userRole.setCreateTime(new Date());
        userRole.setCreateUserId(currentId);
        userRole.setUpdateUserId(currentId);
        userRole.setUpdateTime(new Date());
        userRoleServer.save(userRole);
    }

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(User record) throws ApplicationException {
        iUserDao.insert(record);
    }

    @Override
    public void saveSelective(User record) throws ApplicationException {

    }

    @Override
    public User selectById(Long id) throws ApplicationException {
        User user = iUserDao.selectByPrimaryKey(id);
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateByIdSelective(User record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 根据id更新实体数据，不管数据是否为空都更新覆盖
     * @return 返回无，出错抛出异常
     * @update
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateById(User record) throws ApplicationException {
        iUserDao.updateByPrimaryKey(record);
    }
}
