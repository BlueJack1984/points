package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.VisiblePO;
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
public class SystemBonus extends VisiblePO<Long> {

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
}