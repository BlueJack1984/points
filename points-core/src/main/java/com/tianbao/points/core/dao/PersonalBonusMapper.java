package com.tianbao.points.core.dao;

import com.example.mybatisdemo.entity.PersonalBonus;

public interface PersonalBonusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalBonus record);

    int insertSelective(PersonalBonus record);

    PersonalBonus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalBonus record);

    int updateByPrimaryKey(PersonalBonus record);
}