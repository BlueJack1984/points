package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao<User, Long> {

}