package com.tianbao.points.core.dao;

import com.example.demo.pojo.PointTx;
import com.example.demo.pojo.PointTxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointTxMapper {
    long countByExample(PointTxExample example);

    int deleteByExample(PointTxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PointTx record);

    int insertSelective(PointTx record);

    List<PointTx> selectByExample(PointTxExample example);

    PointTx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PointTx record, @Param("example") PointTxExample example);

    int updateByExample(@Param("record") PointTx record, @Param("example") PointTxExample example);

    int updateByPrimaryKeySelective(PointTx record);

    int updateByPrimaryKey(PointTx record);
}