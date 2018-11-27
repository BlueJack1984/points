package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.UserMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMessageDao extends BaseDao<UserMessage, Long> {

}