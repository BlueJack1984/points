package com.tianbao.points.core.dao;

import com.example.mybatisdemo.entity.Rank;

public interface RankMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Rank record);

    int insertSelective(Rank record);

    Rank selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Rank record);

    int updateByPrimaryKey(Rank record);
}