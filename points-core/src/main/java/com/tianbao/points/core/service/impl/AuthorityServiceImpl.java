package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IAuthorityDao;
import com.tianbao.points.core.entity.Authority;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IAuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 权限服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements IAuthorityService {
    /**
     * 注入权限dao
     */
    private final IAuthorityDao iAuthorityDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(Authority record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Authority record) throws ApplicationException {

    }

    @Override
    public Authority selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Authority record) throws ApplicationException {

    }

    @Override
    public void updateById(Authority record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据用户id获取所有的权限列表
     * @param userId 当前用户id
     * @return 返回查询到的权限列表
     * @update
     */
    @Override
    public List<Authority> getListByUserId(Long userId) throws ApplicationException {
        return null;
    }
}
