package com.tianbao.points.core.dao;

import com.example.demo.pojo.Point;
import com.example.demo.pojo.PointExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointMapper {
    long countByExample(PointExample example);

    int deleteByExample(PointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Point record);

    int insertSelective(Point record);

    List<Point> selectByExample(PointExample example);

    Point selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Point record, @Param("example") PointExample example);

    int updateByExample(@Param("record") Point record, @Param("example") PointExample example);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);
}