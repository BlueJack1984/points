package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IRoleAuthorityDao;
import com.tianbao.points.core.entity.RoleAuthority;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRoleAuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 角色权限关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class RoleAuthorityServiceImpl implements IRoleAuthorityService {
    /**
     * 自动注入角色权限关联dao
     */
    private final IRoleAuthorityDao iRoleAuthorityDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public RoleAuthority save(RoleAuthority record) throws ApplicationException {
        return null;
    }

    @Override
    public RoleAuthority saveSelective(RoleAuthority record) throws ApplicationException {
        return null;
    }

    @Override
    public RoleAuthority selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(RoleAuthority record) throws ApplicationException {

    }

    @Override
    public void updateById(RoleAuthority record) throws ApplicationException {

    }
}
