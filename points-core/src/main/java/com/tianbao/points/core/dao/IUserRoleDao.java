package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IUserRoleDao extends IBaseDao<UserRole, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-05
     * @Desc 根据实体ids查询用户角色列表
     * 每个用户id都对应一个角色列表，一个用户id集合对应一个角色集合的集合
     * @param ids 用户的id集合
     * @return 返回无，出错抛出异常
     * @update
     */
    List<List<UserRole>> getListByUserIds(@Param("ids") List<Long> ids);
}