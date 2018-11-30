package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IUserDao;
import com.tianbao.points.core.dto.PositionDTO;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPositionService;
import com.tianbao.points.core.service.IRoleService;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.BeanHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @Override
    public void updatePassword(Long id) throws ApplicationException {
        //@Value("${master.apply.image.key}")
        //private String MASTER_APPLY_IMAGE_KEY;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的超级密码，这个用户只有一个，顶级管理员，所以要先判断身份
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @Override
    public void updateSuperPassword(Long id) throws ApplicationException {

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

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

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

    @Override
    public void updateByIdSelective(User record) throws ApplicationException {

    }

    @Override
    public void updateById(User record) throws ApplicationException {

    }
}
