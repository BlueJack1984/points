package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao extends IBaseDao<User, Long> {

}