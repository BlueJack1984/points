package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

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
}