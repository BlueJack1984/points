package com.tianbao.points.core.dao;

import com.example.mybatisdemo.entity.UserMessage;

public interface UserMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}