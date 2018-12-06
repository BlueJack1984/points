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
     * @Date 2018-12-06
     * @Desc 根据用户id查询用户角色列表
     * 每个用户id都对应一个角色列表，一个用户id对应一个角色集合
     * @param userId 用户的id
     * @return 返回用户角色列表
     * @update
     */
    List<UserRole> getListByUserId(@Param("userId") Long userId);

    /**
     * @author lushusheng
     * @Date 2018-12-06
     * @Desc 根据id批量更新实体
     * 每个用户id都对应一个角色列表，一个用户id对应一个角色集合
     * @param userRoleList 实体集合
     * @return 无返回
     * @update
     */
    void updateBatch(@Param("userRoleList") List<UserRole> userRoleList);
}