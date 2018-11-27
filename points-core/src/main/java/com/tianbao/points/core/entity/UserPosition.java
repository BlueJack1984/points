package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;


/**
 * @desc 用户职位关联表实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_position")
public class UserPosition extends ObjectPO<Long> {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 职位id
     */
    private Long positionId;
}