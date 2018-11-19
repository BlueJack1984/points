package com.tianbao.points.core.dao;

import com.example.demo.pojo.PointList;
import com.example.demo.pojo.PointListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointListMapper {
    long countByExample(PointListExample example);

    int deleteByExample(PointListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PointList record);

    int insertSelective(PointList record);

    List<PointList> selectByExampleWithBLOBs(PointListExample example);

    List<PointList> selectByExample(PointListExample example);

    PointList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PointList record, @Param("example") PointListExample example);

    int updateByExampleWithBLOBs(@Param("record") PointList record, @Param("example") PointListExample example);

    int updateByExample(@Param("record") PointList record, @Param("example") PointListExample example);

    int updateByPrimaryKeySelective(PointList record);

    int updateByPrimaryKeyWithBLOBs(PointList record);

    int updateByPrimaryKey(PointList record);
}