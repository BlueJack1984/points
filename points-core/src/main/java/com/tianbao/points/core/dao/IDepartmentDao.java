package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDepartmentDao extends BaseDao<Department, Long> {

}