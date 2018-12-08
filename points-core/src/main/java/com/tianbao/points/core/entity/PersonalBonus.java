package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import com.tianbao.points.core.entity.base.VisiblePO;
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
public class PersonalBonus extends VisiblePO<Long> {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 系统每天积分增值（表）id
     */
    private Long systemBonusId;
    /**
     * 上次的个人积分增值记录id
     */
    private Long parentId;
    /**
     * 用户当天结算前积分
     */
    private Double startPoints;
    /**
     * 用户当天结算后积分
     */
    private Double endPoints;
    /**
     * 用户当天结算的权重比率，与系统当天结算比率相同
     */
    private Double ratio;
}