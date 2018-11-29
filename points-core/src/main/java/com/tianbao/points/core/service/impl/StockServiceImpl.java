package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IStockDao;
import com.tianbao.points.core.entity.Stock;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(Stock record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Stock record) throws ApplicationException {

    }

    @Override
    public Stock selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Stock record) throws ApplicationException {

    }

    @Override
    public void updateById(Stock record) throws ApplicationException {

    }
}
