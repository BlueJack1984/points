package com.tianbao.points.core.service;


import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 角色服务接口
 * @author lushusheng
 * @date 2018-11-27
 *假定，用户和角色是一对一关系，即一个用户只有一个角色；
 * 角色和用户的关系是一对多关系，一个角色对应着多个用户
 * 角色和权限的关系是多对多关系。即一个角色有着多种权限，
 * 同样，一个权限可以分给不同角色。
 */
public interface IRoleService extends IBaseService<Role, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据用户id查询相关角色集合，一个用户可以对应多个角色
     * @return 返回角色集合数据
     * @update
     */
    List<Role> getListByUserId(Long userId)throws ApplicationException;
}
