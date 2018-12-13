package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IAuthorityDao extends IBaseDao<Authority, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据用户id获取所有的权限列表
     * @param userId 当前用户id
     * @return 返回查询到的权限列表
     * @update
     */
    List<Authority> getListByUserId(@Param("userId") Long userId);
}