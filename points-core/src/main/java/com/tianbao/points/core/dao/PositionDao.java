package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.Position;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PositionDao extends BaseDao<Position, Long> {

}