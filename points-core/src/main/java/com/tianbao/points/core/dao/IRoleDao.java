package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IRoleDao extends IBaseDao<Role, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据用户id查询相关角色列表
     * @return 返回查询到的角色列表
     * @update
     */
    List<Role> selectListByUserId(@Param("userId") Long userId);
}