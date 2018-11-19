package com.tianbao.points.core.dao;

import com.example.demo.pojo.UpLevel;
import com.example.demo.pojo.UpLevelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpLevelMapper {
    long countByExample(UpLevelExample example);

    int deleteByExample(UpLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UpLevel record);

    int insertSelective(UpLevel record);

    List<UpLevel> selectByExample(UpLevelExample example);

    UpLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UpLevel record, @Param("example") UpLevelExample example);

    int updateByExample(@Param("record") UpLevel record, @Param("example") UpLevelExample example);

    int updateByPrimaryKeySelective(UpLevel record);

    int updateByPrimaryKey(UpLevel record);
}