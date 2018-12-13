package com.tianbao.points.core.service;


import com.tianbao.points.core.entity.Authority;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 权限服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IAuthorityService extends IBaseService<Authority, Long> {
    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据用户id获取所有的权限列表
     * @param userId 当前用户id
     * @return 返回查询到的权限列表
     * @update
     */
    List<Authority> getListByUserId(Long userId)throws ApplicationException;
}
