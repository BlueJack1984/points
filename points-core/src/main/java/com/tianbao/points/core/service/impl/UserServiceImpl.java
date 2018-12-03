package com.tianbao.points.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dao.IUserDao;
import com.tianbao.points.core.dto.PositionDTO;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPositionService;
import com.tianbao.points.core.service.IRankService;
import com.tianbao.points.core.service.IRoleService;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.BeanHelper;
import com.tianbao.points.core.utils.DES;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc 首页公告服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
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
     * 注入角色服务service
     */
    private final IRoleService roleServer;
    /**
     * 注入会员等级service
     */
    private final IRankService rankServer;

    @Value("${password.encrypt.key}")
    private String PASSWORD_SECRET_KEY;
    @Value("${super.admin.role.id}")
    private String SUPER_ADMIN_ROLE_ID;
    @Value("${reset.member.password}")
    private String MEMBER_COMMON_PASSWORD;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取用户的个人档案资料，包装了职位和角色信息
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
        BeanHelper.copyProperties(userDTO, user);
        //根据用户id获取相关职位信息
        List<PositionDTO> positionDTOList = positionServer.getListByUserId(id);
        userDTO.setPositionDTOList(positionDTOList);
        //根据用户id获取用户角色信息
        List<Role> roleList = roleServer.getListByUserId(id);
        userDTO.setRoleList(roleList);
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
            throw new ApplicationException(1, "新密码与确认密码不同");
        }
        if(oldPassword.equals(newPassword)) {
            throw new ApplicationException(1, "原密码与新密码相同，请输入新密码");
        }
        byte[] encoded = DES.encrypt(PASSWORD_SECRET_KEY.getBytes(), oldPassword.getBytes());
        String encodedPassword = new String(encoded);
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
        encoded = DES.encrypt(PASSWORD_SECRET_KEY.getBytes(), newPassword.getBytes());
        encodedPassword = new String(encoded);
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
    public List<User> getListByIdsPage(List<Long> ids) throws ApplicationException {
        List<User> userList = iUserDao.getListByIdsPage(ids);
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
        return iUserDao.getList();
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
        PageHelper.startPage(pageNo, pageSize);
        List<User> userList = iUserDao.selectListPage();
        if(userList == null || userList.size() <= 0) {
            throw new ApplicationException(1, "");
        }
        List<Rank> rankList = rankServer.getList();
        List<UserDTO> userDTOList = new ArrayList<>();
        copyRankProperties(userDTOList, userList, rankList);
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userDTOList);
        return pageInfo;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 拷贝等级属性到用户实体中
     * @return 返回查询到的数据列表
     * @update
     */
    private void copyRankProperties(List<UserDTO> target, List<User> userList, List<Rank> rankList) throws ApplicationException{
        for(User user: userList) {
            UserDTO userDTO = new UserDTO();
            BeanHelper.copyProperties(userDTO, user);
            for(Rank rank: rankList) {
                if(rank.getId().equals(user.getRankId())) {
                    userDTO.setRank(rank);
                    break;
                }
            }
            target.add(userDTO);
        }
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
            throw new ApplicationException(1, "");
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
            throw new ApplicationException(1, "");
        }
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        byte[] encoded = DES.encrypt(PASSWORD_SECRET_KEY.getBytes(), MEMBER_COMMON_PASSWORD.getBytes());
        String commonPassword = new String(encoded);
        user.setPassword(commonPassword);
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
        List<UserDTO> userDTOList = new ArrayList<>();
        if(userList == null) {
            return new PageInfo<>(userDTOList);
        }
        List<Rank> rankList = rankServer.getList();
        copyRankProperties(userDTOList, userList, rankList);
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
            List<Role> roleList = roleServer.getListByUserId(admin.getId());
            userDTO.setRoleList(roleList);
            userDTOList.add(userDTO);
        }
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userDTOList);
        return pageInfo;
    }

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Transactional
    @Override
    public void save(User record) throws ApplicationException {

    }

    @Override
    public void saveSelective(User record) throws ApplicationException {

    }

    @Override
    public User selectById(Long id) throws ApplicationException {
        return null;
    }

    @Transactional
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
    @Transactional
    @Override
    public void updateById(User record) throws ApplicationException {
        iUserDao.updateByPrimaryKey(record);
    }
}
