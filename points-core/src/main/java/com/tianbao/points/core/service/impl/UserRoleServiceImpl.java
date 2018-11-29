package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IUserRoleDao;
import com.tianbao.points.core.entity.UserRole;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 用户角色关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements IUserRoleService {

    /**
     * 注入用户角色关联dao
     */
    private final IUserRoleDao iUserRoleDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public UserRole save(UserRole record) throws ApplicationException {
        return null;
    }

    @Override
    public UserRole saveSelective(UserRole record) throws ApplicationException {
        return null;
    }

    @Override
    public UserRole selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(UserRole record) throws ApplicationException {

    }

    @Override
    public void updateById(UserRole record) throws ApplicationException {

    }
}
