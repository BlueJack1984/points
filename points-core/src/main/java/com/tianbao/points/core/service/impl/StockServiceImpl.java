package com.tianbao.points.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IStockDao;
import com.tianbao.points.core.entity.Stock;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Transactional
    @Override
    public void deleteById(Long id) throws ApplicationException {
        iStockDao.deleteByPrimaryKey(id);
    }

    @Transactional
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

    @Transactional
    @Override
    public void updateByIdSelective(Stock record) throws ApplicationException {

    }
    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据实体id更新证券指数数据
     * @param record 表示要更新的实体
     * @return 无返回
     * @update
     */
    @Transactional
    @Override
    public void updateById(Stock record) throws ApplicationException {
        iStockDao.updateByPrimaryKey(record);
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

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询股票证券指数列表，不分页
     * @param num 表示要取得数据条数
     * @return 返回查询到的数据列表,正序排列，最新的num条
     * @update
     */
    @Override
    public List<Stock> getListNum(Integer num) throws ApplicationException {
        List<Stock> stockList = iStockDao.selectListNum(num);
        return stockList;
    }

    /**
     * @author lushusheng
     * @Date 2018-12-03
     * @Desc 保存一个实体数据
     * @param currentId 当前管理员id
     * @param record 保存的实体信息
     * @return 返回插入的数据，便于回显
     * @update
     */
    @Override
    public Stock insert(Long currentId, Stock record) throws ApplicationException {
        record.setStatus(StatusCode.NORMAL.getCode());
        record.setCreateUserId(currentId);
        record.setUpdateUserId(record.getCreateUserId());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        iStockDao.insert(record);
        return record;
    }
}
