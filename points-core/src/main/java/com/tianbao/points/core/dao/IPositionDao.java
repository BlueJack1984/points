package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface IPositionDao extends IBaseDao<Position, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据用户id查询职位列表,个人档案部分使用
     * @param userId 用户id
     * @return 返回职位列表
     * @update
     */
    List<Position> selectListByUserId(@Param("userId") Long userId);
}