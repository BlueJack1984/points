package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 权限输入实体
 * @author lushusheng
 * @date 2019-1-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityMigrationInput {

    /**
     * 权限id
     */
    @NotNull(message = "权限id参数不能为空")
    private Long id;
    /**
     * 权限编号
     */
    @NotBlank(message = "权限编号参数不能为空")
    private String code;
    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称参数不能为空")
    private String name;

    /**
     * 权限请求对应的url地址
     */
    @NotBlank(message = "url地址参数不能为空")
    private String url;
    /**
     * 权限允许的名称
     */
    @NotBlank(message = "权限允许的名称参数不能为空")
    private String permission;
    /**
     * 权限类型
     */
    @NotNull(message = "权限类型参数不能为空")
    private Integer type;
    /**
     * 权限描述
     */
    @NotBlank(message = "权限描述参数不能为空")
    private String description;
}
