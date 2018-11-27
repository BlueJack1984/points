package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.Rank;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RankDao extends BaseDao<Rank, Long> {

}