package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.PersonalBonus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalBonusDao extends BaseDao<PersonalBonus, Long> {

}