package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Authority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAuthorityDaoI extends IBaseDao<Authority, Long> {

}