package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @desc 会员等级实体，类似枚举
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "rank")
public class Rank extends ObjectPO<Long> {

    /**
     * 会员等级名称
     */
    private String name;
    /**
     * 会员等级别名
     */
    private String alias;
    /**
     * 该会员等级进行积分结算的基准值
     * 用它来乘以权重比率
     */
    private Integer basePoints;
    /**
     * 晋升到该会员等级需要交纳的金额
     */
    private Double baseMoney;
}