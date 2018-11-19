package com.tianbao.points.core.dao;

import com.example.demo.pojo.WebConfig;
import com.example.demo.pojo.WebConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebConfigMapper {
    long countByExample(WebConfigExample example);

    int deleteByExample(WebConfigExample example);

    int deleteByPrimaryKey(String varname);

    int insert(WebConfig record);

    int insertSelective(WebConfig record);

    List<WebConfig> selectByExampleWithBLOBs(WebConfigExample example);

    List<WebConfig> selectByExample(WebConfigExample example);

    WebConfig selectByPrimaryKey(String varname);

    int updateByExampleSelective(@Param("record") WebConfig record, @Param("example") WebConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") WebConfig record, @Param("example") WebConfigExample example);

    int updateByExample(@Param("record") WebConfig record, @Param("example") WebConfigExample example);

    int updateByPrimaryKeySelective(WebConfig record);

    int updateByPrimaryKeyWithBLOBs(WebConfig record);

    int updateByPrimaryKey(WebConfig record);
}