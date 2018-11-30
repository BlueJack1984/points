package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IRoleDao;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 角色服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    /**
     * 注入角色dao
     */
    private final IRoleDao iRoleDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(Role record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Role record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id查询角色实体
     * @return 返回角色实体
     * @update
     */
    @Override
    public Role selectById(Long id) throws ApplicationException {
        Role role = iRoleDao.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public void updateByIdSelective(Role record) throws ApplicationException {

    }

    @Override
    public void updateById(Role record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据用户id查询相关角色列表，一个用户可以对应多个角色
     * @return 返回角色集合数据
     * @update
     */
    @Override
    public List<Role> getListByUserId(Long userId) throws ApplicationException {
        List<Role> roleList = iRoleDao.selectListByUserId(userId);
        return roleList;
    }
}
