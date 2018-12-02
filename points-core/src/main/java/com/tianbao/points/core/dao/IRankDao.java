package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Rank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IRankDao extends IBaseDao<Rank, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-01
     * @Desc 查询会员等级列表，不分页
     * @return 返回会员等级集合数据
     * @update
     */
    List<Rank> selectList();
}