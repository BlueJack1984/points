package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.Authority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAuthorityDao extends BaseDao<Authority, Long> {

}