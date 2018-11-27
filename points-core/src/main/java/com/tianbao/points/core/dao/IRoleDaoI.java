package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleDaoI extends IBaseDao<Role, Long> {

}