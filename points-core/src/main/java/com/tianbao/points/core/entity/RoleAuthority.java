package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @desc 角色权限关联表实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "role_authority")
public class RoleAuthority extends ObjectPO<Long> {

    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id
     */
    private Long authorityId;
}