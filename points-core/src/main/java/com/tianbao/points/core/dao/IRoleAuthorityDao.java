package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.RoleAuthority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleAuthorityDao extends IBaseDao<RoleAuthority, Long> {

}