package com.tianbao.points.core.dao;

import com.example.demo.pojo.UpPosition;
import com.example.demo.pojo.UpPositionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpPositionMapper {
    long countByExample(UpPositionExample example);

    int deleteByExample(UpPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UpPosition record);

    int insertSelective(UpPosition record);

    List<UpPosition> selectByExample(UpPositionExample example);

    UpPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UpPosition record, @Param("example") UpPositionExample example);

    int updateByExample(@Param("record") UpPosition record, @Param("example") UpPositionExample example);

    int updateByPrimaryKeySelective(UpPosition record);

    int updateByPrimaryKey(UpPosition record);
}