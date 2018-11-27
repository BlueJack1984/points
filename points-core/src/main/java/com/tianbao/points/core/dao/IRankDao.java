package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Rank;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRankDao extends IBaseDao<Rank, Long> {

}