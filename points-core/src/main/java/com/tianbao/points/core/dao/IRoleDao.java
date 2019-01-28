package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.exception.ApplicationException;
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

    /**
     * @desc 获取角色列表，分页展示
     * @author lushusheng
     * @Date 2018-12-03
     * @return 返回数据列表
     *
     */
    List<Role> selectListPage();
    /**
     * @desc 数据迁移，存入角色数据
     * @author lushusheng
     * @Date 2019-1-28
     * @return
     *
     */
    void insertMigration(Role role);
}
