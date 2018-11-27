package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Stock;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IStockDaoI extends IBaseDao<Stock, Long> {

}