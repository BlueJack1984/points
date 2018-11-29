package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IDepartmentDao extends IBaseDao<Department, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据部门的id集合查询部门列表,个人档案部分使用
     * @param ids 部门的id集合
     * @return 返回部门列表
     * @update
     */
    List<Department> selectListByIds(@Param("ids") List<Long> ids);
}