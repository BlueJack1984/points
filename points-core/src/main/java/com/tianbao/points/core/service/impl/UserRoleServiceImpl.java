package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IUserRoleDao;
import com.tianbao.points.core.entity.UserRole;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void save(UserRole record) throws ApplicationException {
        iUserRoleDao.insert(record);
    }

    @Override
    public void saveSelective(UserRole record) throws ApplicationException {

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
    /**
     * @author lushusheng
     * @Date 2018-12-05
     * @Desc 根据实体ids查询用户角色列表
     * 每个用户id都对应一个角色列表，一个用户id集合对应一个角色集合的集合
     * @param ids 用户的id集合
     * @return 返回无，出错抛出异常
     * @update
     */
    @Override
    public List<List<UserRole>> getListByUserIds(List<Long> ids) throws ApplicationException {
        List<List<UserRole>> userRoleList = iUserRoleDao.getListByUserIds(ids);
        return userRoleList;
    }
}
