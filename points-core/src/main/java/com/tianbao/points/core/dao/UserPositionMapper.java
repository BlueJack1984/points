package com.tianbao.points.core.dao;

import com.tianbao.points.core.entity.UserPosition;

public interface UserPositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPosition record);

    int insertSelective(UserPosition record);

    UserPosition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPosition record);

    int updateByPrimaryKey(UserPosition record);
}