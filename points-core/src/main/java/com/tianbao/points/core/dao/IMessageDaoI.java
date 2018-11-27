package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMessageDaoI extends IBaseDao<Message, Long> {

}