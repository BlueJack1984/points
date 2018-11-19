package com.tianbao.points.core.dao;

import com.example.demo.pojo.SendMoney;
import com.example.demo.pojo.SendMoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SendMoneyMapper {
    long countByExample(SendMoneyExample example);

    int deleteByExample(SendMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SendMoney record);

    int insertSelective(SendMoney record);

    List<SendMoney> selectByExampleWithBLOBs(SendMoneyExample example);

    List<SendMoney> selectByExample(SendMoneyExample example);

    SendMoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SendMoney record, @Param("example") SendMoneyExample example);

    int updateByExampleWithBLOBs(@Param("record") SendMoney record, @Param("example") SendMoneyExample example);

    int updateByExample(@Param("record") SendMoney record, @Param("example") SendMoneyExample example);

    int updateByPrimaryKeySelective(SendMoney record);

    int updateByPrimaryKeyWithBLOBs(SendMoney record);

    int updateByPrimaryKey(SendMoney record);
}