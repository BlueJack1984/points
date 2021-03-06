package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Rank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 查询会员等级列表，分页
     * @return 返回会员等级集合数据
     * @update
     */
    List<Rank> selectListPage();

    /**
     * @desc 通过排序编号查询会员等级
     * @author lushusheng 2018-12-05
     * @param order 排序编号
     * @return 返回查询到的数据
     */
    Rank getByOrder(@Param("order") Integer order);

    /**
     * @desc 数据迁移，插入会员等级数据
     * @author lushusheng 2019-1-28
     * @param rank 排序编号
     * @return
     */
    void insertMigration(Rank rank);

}
