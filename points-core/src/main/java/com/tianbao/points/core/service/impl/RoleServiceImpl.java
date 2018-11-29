package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IRoleDao;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public Role selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Role record) throws ApplicationException {

    }

    @Override
    public void updateById(Role record) throws ApplicationException {

    }
}
