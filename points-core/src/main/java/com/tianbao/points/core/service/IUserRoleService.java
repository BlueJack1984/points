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
     * @Date 2018-12-06
     * @Desc 根据用户id查询用户角色列表
     * 每个用户id都对应一个角色列表，一个用户id对应一个角色集合
     * @param userId 用户的id
     * @return 返回用户角色列表
     * @update
     */
    List<UserRole> getListByUserId(Long userId) throws ApplicationException;
    /**
     * @author lushusheng
     * @Date 2018-12-06
     * @Desc 根据id批量更新实体
     * 每个用户id都对应一个角色列表，一个用户id对应一个角色集合
     * @param userRoleList 实体集合
     * @return 无返回
     * @update
     */
    void updateBatch(List<UserRole> userRoleList) throws ApplicationException;
}
