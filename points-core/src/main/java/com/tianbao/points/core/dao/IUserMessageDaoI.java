package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.UserMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMessageDaoI extends IBaseDao<UserMessage, Long> {

}