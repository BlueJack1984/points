package com.tianbao.points.core.dao;

import com.example.demo.pojo.MoneyUseList;
import com.example.demo.pojo.MoneyUseListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoneyUseListMapper {
    long countByExample(MoneyUseListExample example);

    int deleteByExample(MoneyUseListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MoneyUseList record);

    int insertSelective(MoneyUseList record);

    List<MoneyUseList> selectByExample(MoneyUseListExample example);

    MoneyUseList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MoneyUseList record, @Param("example") MoneyUseListExample example);

    int updateByExample(@Param("record") MoneyUseList record, @Param("example") MoneyUseListExample example);

    int updateByPrimaryKeySelective(MoneyUseList record);

    int updateByPrimaryKey(MoneyUseList record);
}