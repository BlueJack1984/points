package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMessageDao extends BaseDao<Message, Long> {

}