package com.tianbao.points.core.dao;

import com.example.demo.pojo.MoneyUse;
import com.example.demo.pojo.MoneyUseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoneyUseMapper {
    long countByExample(MoneyUseExample example);

    int deleteByExample(MoneyUseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MoneyUse record);

    int insertSelective(MoneyUse record);

    List<MoneyUse> selectByExample(MoneyUseExample example);

    MoneyUse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MoneyUse record, @Param("example") MoneyUseExample example);

    int updateByExample(@Param("record") MoneyUse record, @Param("example") MoneyUseExample example);

    int updateByPrimaryKeySelective(MoneyUse record);

    int updateByPrimaryKey(MoneyUse record);
}