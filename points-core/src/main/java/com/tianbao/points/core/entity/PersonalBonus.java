package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @desc 个人用户积分结算实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "personal_bonus")
public class PersonalBonus extends ObjectPO<Long> {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 系统每天积分增值（表）id
     */
    private Long systemBonusId;
    /**
     * 用户当天结算后积分
     */
    private Double points;
    /**
     * 用户当天结算的权重比率，与系统当天结算比率相同
     */
    private Double ratio;
    /**
     * 此数据是否对会员客户端可见，0表示正常可见，1表示不可见
     */
    private Integer visible;
    /**
     * 上次的个人积分增值记录id
     */
    private Long lastPersonalBonusId;
}