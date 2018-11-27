package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.Stock;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IStockDao extends BaseDao<Stock, Long> {

}