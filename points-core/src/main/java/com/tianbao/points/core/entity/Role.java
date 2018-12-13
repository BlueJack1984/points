package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @desc 角色实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "role")
public class Role extends ObjectPO<Long> {

    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 平台作用域：0表示管理后台，1表示会员客户端app
     */
    private Integer domain;
    /**
     * 平台用户类型，做权限的时候再详细考虑
     * todo
     */
    private Integer type;
    /**
     * 对于管理员角色存在的字段，标识管理员等级排序
     */
    private Integer order;
}