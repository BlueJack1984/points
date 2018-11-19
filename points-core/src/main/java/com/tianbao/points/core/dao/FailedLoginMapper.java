package com.tianbao.points.core.dao;

import com.example.demo.pojo.FailedLogin;
import com.example.demo.pojo.FailedLoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FailedLoginMapper {
    long countByExample(FailedLoginExample example);

    int deleteByExample(FailedLoginExample example);

    int deleteByPrimaryKey(String username);

    int insert(FailedLogin record);

    int insertSelective(FailedLogin record);

    List<FailedLogin> selectByExample(FailedLoginExample example);

    FailedLogin selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") FailedLogin record, @Param("example") FailedLoginExample example);

    int updateByExample(@Param("record") FailedLogin record, @Param("example") FailedLoginExample example);

    int updateByPrimaryKeySelective(FailedLogin record);

    int updateByPrimaryKey(FailedLogin record);
}