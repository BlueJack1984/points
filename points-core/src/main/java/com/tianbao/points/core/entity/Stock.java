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

    private Date publishTime;

    private Double shOpenExponent;

    private Double shCloseExponent;

    private Double shMaxExponent;

    private Double shMinExponent;

    private Double tbOpenExponent;

    private Double tbCloseExponent;

    private Double tbMaxExponent;

    private Double tbMinExponent;
}