package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * @desc 股票证券指数实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "stock")
public class Stock extends ObjectPO<Long> {

    /**
     * 证券信息发布时间
     */
    private Date publishTime;
    /**
     * 上证开盘指数
     */
    private Double shOpenExponent;
    /**
     * 上证收盘指数
     */
    private Double shCloseExponent;
    /**
     * 上证最高指数
     */
    private Double shMaxExponent;
    /**
     * 上证最低指数
     */
    private Double shMinExponent;
    /**
     * 天宝开盘指数
     */
    private Double tbOpenExponent;
    /**
     * 天宝收盘指数
     */
    private Double tbCloseExponent;
    /**
     * 天宝最高指数
     */
    private Double tbMaxExponent;
    /**
     * 天宝最低指数
     */
    private Double tbMinExponent;
}