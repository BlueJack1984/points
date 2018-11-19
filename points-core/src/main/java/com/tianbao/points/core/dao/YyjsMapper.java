package com.tianbao.points.core.dao;

import com.example.demo.pojo.Yyjs;
import com.example.demo.pojo.YyjsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YyjsMapper {
    long countByExample(YyjsExample example);

    int deleteByExample(YyjsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Yyjs record);

    int insertSelective(Yyjs record);

    List<Yyjs> selectByExample(YyjsExample example);

    Yyjs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Yyjs record, @Param("example") YyjsExample example);

    int updateByExample(@Param("record") Yyjs record, @Param("example") YyjsExample example);

    int updateByPrimaryKeySelective(Yyjs record);

    int updateByPrimaryKey(Yyjs record);
}