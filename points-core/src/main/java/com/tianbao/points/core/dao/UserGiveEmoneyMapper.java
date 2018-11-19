package com.tianbao.points.core.dao;

import com.example.demo.pojo.UserGiveEmoney;
import com.example.demo.pojo.UserGiveEmoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGiveEmoneyMapper {
    long countByExample(UserGiveEmoneyExample example);

    int deleteByExample(UserGiveEmoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserGiveEmoney record);

    int insertSelective(UserGiveEmoney record);

    List<UserGiveEmoney> selectByExampleWithBLOBs(UserGiveEmoneyExample example);

    List<UserGiveEmoney> selectByExample(UserGiveEmoneyExample example);

    UserGiveEmoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserGiveEmoney record, @Param("example") UserGiveEmoneyExample example);

    int updateByExampleWithBLOBs(@Param("record") UserGiveEmoney record, @Param("example") UserGiveEmoneyExample example);

    int updateByExample(@Param("record") UserGiveEmoney record, @Param("example") UserGiveEmoneyExample example);

    int updateByPrimaryKeySelective(UserGiveEmoney record);

    int updateByPrimaryKeyWithBLOBs(UserGiveEmoney record);

    int updateByPrimaryKey(UserGiveEmoney record);
}