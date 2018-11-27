package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserRoleDaoI extends IBaseDao<UserRole, Long> {

}