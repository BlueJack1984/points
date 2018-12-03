package com.tianbao.points.core.service;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.entity.Stock;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 股票证券指数服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IStockService extends IBaseService<Stock, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询股票证券指数列表，分页倒叙查询
     * @param pageNo 表示显示的页码
     * @param pageSize 表示每页要显示的条数
     * @return 返回查询到的数据列表
     * @update
     */
    PageInfo<Stock> getListPage(Integer pageNo, Integer pageSize)throws ApplicationException;
    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询股票证券指数列表，不分页
     * @param num 表示要取得数据条数
     * @return 返回查询到的数据列表,正序排列，最新的num条
     * @update
     */
    List<Stock> getListNum(Integer num)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-12-03
     * @Desc 保存一个实体数据
     * @param currentId 当前管理员id
     * @param record 保存的实体信息
     * @return 返回插入的数据，便于回显
     * @update
     */
    Stock insert(Long currentId, Stock record) throws ApplicationException;
}
