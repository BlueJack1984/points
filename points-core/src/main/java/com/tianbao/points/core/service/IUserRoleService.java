package com.tianbao.points.core.service;

import com.tianbao.points.core.entity.UserRole;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 用户角色关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IUserRoleService extends IBaseService<UserRole, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-05
     * @Desc 根据实体ids查询用户角色列表
     * 每个用户id都对应一个角色列表，一个用户id集合对应一个角色集合的集合
     * @param ids 用户的id集合
     * @return 返回无，出错抛出异常
     * @update
     */
    List<List<UserRole>> getListByUserIds(List<Long> ids) throws ApplicationException;
}
