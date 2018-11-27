package com.tianbao.points.core.dao;

import com.tianbao.points.core.entity.SystemBonus;

public interface SystemBonusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemBonus record);

    int insertSelective(SystemBonus record);

    SystemBonus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemBonus record);

    int updateByPrimaryKey(SystemBonus record);
}