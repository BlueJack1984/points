package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.UserPosition;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserPositionDao extends BaseDao<UserPosition, Long> {

}