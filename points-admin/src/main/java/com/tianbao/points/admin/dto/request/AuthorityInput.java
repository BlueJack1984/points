package com.tianbao.points.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 权限输入参数实体
 * @author lushusheng
 * @date 2018-12-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityInput {
    /**
     * 权限编号
     */
    //@NotBlank(message = "权限编号参数不能为空")
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
     * 权限url地址的简写名称
     */
    @NotBlank(message = "权限url地址的简写名称不能为空")
    private String permission;
    /**
     * 权限类型，0表示菜单，1表示按钮
     */
    @NotNull(message="权限类型不能为空")
    private Integer type;
    /**
     * 权限描述
     */
    //@NotBlank(message = "权限描述参数不能为空")
    private String description;
}
