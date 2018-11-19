package com.tianbao.points.core.dao;

import com.example.demo.pojo.AdminGroup;
import com.example.demo.pojo.AdminGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminGroupMapper {
    long countByExample(AdminGroupExample example);

    int deleteByExample(AdminGroupExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(AdminGroup record);

    int insertSelective(AdminGroup record);

    List<AdminGroup> selectByExampleWithBLOBs(AdminGroupExample example);

    List<AdminGroup> selectByExample(AdminGroupExample example);

    AdminGroup selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") AdminGroup record, @Param("example") AdminGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") AdminGroup record, @Param("example") AdminGroupExample example);

    int updateByExample(@Param("record") AdminGroup record, @Param("example") AdminGroupExample example);

    int updateByPrimaryKeySelective(AdminGroup record);

    int updateByPrimaryKeyWithBLOBs(AdminGroup record);

    int updateByPrimaryKey(AdminGroup record);
}