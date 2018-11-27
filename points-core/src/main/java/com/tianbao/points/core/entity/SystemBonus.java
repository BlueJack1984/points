package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;


/**
 * @desc 系统积分结算实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "system_bonus")
public class SystemBonus extends ObjectPO<Long> {

    /**
     * 系统结算前总积分
     */
    private Double startPoints;
    /**
     * 系统结算后总积分
     */
    private Double endPoints;
    /**
     * 系统结算的权重比率
     */
    private Double ratio;
    /**
     * 是否对会员客户端可见，0表示可见，1表示不可见
     */
    private Integer visible;
}