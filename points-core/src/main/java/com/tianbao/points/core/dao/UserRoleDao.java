package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao extends BaseDao<UserRole, Long> {

}