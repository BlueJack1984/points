package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.UserPosition;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserPositionDaoI extends IBaseDao<UserPosition, Long> {

}