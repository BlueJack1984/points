package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.PersonalBonus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IPersonalBonusDao extends IBaseDao<PersonalBonus, Long> {

}