package com.tianbao.points.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dao.IStockDao;
import com.tianbao.points.core.entity.Stock;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @desc 股票证券指数服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements IStockService {
    /**
     * 注入股票证券指数dao
     */
    private final IStockDao iStockDao;

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据实体id删除特定证券指数数据
     * @param id 表示要删除的实体id
     * @return 无返回
     * @update
     */
    @Override
    public void deleteById(Long id) throws ApplicationException {
        iStockDao.deleteByPrimaryKey(id);
    }

    @Override
    public void save(Stock record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Stock record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 查询股票证券指数列表，分页倒叙查询
     * @param id 表示要查询的实体id
     * @return 返回查询到的数据列表
     * @update
     */
    @Override
    public Stock selectById(Long id) throws ApplicationException {
        Stock stock = iStockDao.selectByPrimaryKey(id);
        return stock;
    }

    @Override
    public void updateByIdSelective(Stock record) throws ApplicationException {

    }

    @Override
    public void updateById(Stock record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询股票证券指数列表，分页倒叙查询
     * @param pageNo 表示显示的页码
     * @param pageSize 表示每页要显示的条数
     * @return 返回查询到的数据列表
     * @update
     */
    @Transactional
    @Override
    public PageInfo<Stock> getListPage(Integer pageNo, Integer pageSize) throws ApplicationException {
        //使用插件
        PageHelper.startPage(pageNo, pageSize);
        List<Stock> stockList = iStockDao.selectListPage();
        PageInfo<Stock> pageInfo = new PageInfo<>(stockList);
        return pageInfo;
    }
}
