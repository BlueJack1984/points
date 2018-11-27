package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.SystemBonus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISystemBonusDao extends IBaseDao<SystemBonus, Long> {

}