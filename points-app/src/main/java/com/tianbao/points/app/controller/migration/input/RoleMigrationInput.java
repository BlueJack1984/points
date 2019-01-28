package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 角色输入实体
 * @author lushusheng
 * @date 2019-1-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMigrationInput {

    /**
     * 角色id
     */
    @NotNull(message = "角色id参数不能为空")
    private Long id;
    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称参数不能为空")
    private String name;
    /**
     * 角色描述
     */
    @NotBlank(message = "角色描述参数不能为空")
    private String description;
    /**
     * 平台作用域：0表示管理后台，1表示会员客户端app
     */
    @NotNull(message = "平台作用域参数不能为空")
    private Integer domain;
    /**
     * 平台用户类型：具体参照设计文档
     */
    @NotNull(message = "平台用户类型参数不能为空")
    private Integer type;
}
