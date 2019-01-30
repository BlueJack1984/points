package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 角色权限关联输入实体
 * @author lushusheng
 * @date 2019-1-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuthorityMigrationInput {

    /**
     * 角色权限关联实体id
     */
    @NotNull(message = "角色权限关联实体id参数不能为空")
    private Long id;
    /**
     * 角色id
     */
    @NotNull(message = "角色id参数不能为空")
    private Long roleId;
    /**
     * 权限id
     */
    @NotNull(message = "权限id参数不能为空")
    private Long authorityId;
}
