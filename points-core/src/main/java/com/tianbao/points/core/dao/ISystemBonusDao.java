package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.SystemBonus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISystemBonusDao extends BaseDao<SystemBonus, Long> {

}