package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @desc 新建管理员信息输入实体
 * @author lushusheng
 * @date 2018-12-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInput {

    /**
     * 管理员用户登录账号
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private String account;
    /**
     * 管理员用户密码
     */
    @NotEmpty(message=" 管理员用户密码不能为空")
    private String password;
    /**
     * 管理员用户密码确认
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private String surePassword;
    /**
     * 管理员用户id
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private Long role_id;
    /**
     * 管理员用户id
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private String realName;
    /**
     * 管理员用户id
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private String identityNumber;
    /**
     * 管理员用户id
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private String phone;
    /**
     * 管理员用户id
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private String email;
    /**
     * 管理员用户id
     */
    @NotEmpty(message=" 管理员用户id不能为空")
    private Integer order;
}
