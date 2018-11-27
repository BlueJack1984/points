package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDaoI extends IBaseDao<User, Long> {

}