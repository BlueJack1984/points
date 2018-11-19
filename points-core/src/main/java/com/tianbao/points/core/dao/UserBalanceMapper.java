package com.tianbao.points.core.dao;

import com.example.demo.pojo.UserBalance;
import com.example.demo.pojo.UserBalanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBalanceMapper {
    long countByExample(UserBalanceExample example);

    int deleteByExample(UserBalanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserBalance record);

    int insertSelective(UserBalance record);

    List<UserBalance> selectByExample(UserBalanceExample example);

    UserBalance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserBalance record, @Param("example") UserBalanceExample example);

    int updateByExample(@Param("record") UserBalance record, @Param("example") UserBalanceExample example);

    int updateByPrimaryKeySelective(UserBalance record);

    int updateByPrimaryKey(UserBalance record);
}