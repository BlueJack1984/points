package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IStockDao extends IBaseDao<Stock, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 查询股票证券指数列表，分页倒叙查询,方法名以page结尾代表分页查询
     * @return 返回查询到的数据列表
     * @update
     */
    List<Stock> selectListPage();

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 查询股票证券指数列表，不分页
     * @param num 表示要取得数据条数
     * @return 返回查询到的数据列表,正序排列，最新的num条
     * @update
     */
    List<Stock> selectListNum(@Param("num")Integer num);
}