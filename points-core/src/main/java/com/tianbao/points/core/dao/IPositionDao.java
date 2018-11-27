package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Position;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IPositionDao extends IBaseDao<Position, Long> {

}