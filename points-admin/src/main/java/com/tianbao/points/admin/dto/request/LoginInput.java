package com.tianbao.points.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @desc 用户登录的信息
 * @author lushusheng
 * @date 2018-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInput {
    /**
     * 登录账号
     */
    @NotEmpty(message = "登录账号不能为空")
    @Size(min = 1, max = 16, message = "登录账号长度有误，规范长度：1~16位")
    private String account;
    /**
     * 登录密码
     */
    @NotEmpty(message="请填写密码")
    @Size(min=6, max=18, message="密码长度有误,长度：6-18位")
    private String password;
    /**
     * 图形验证码
     */
    @NotEmpty(message="请填写图形验证码")
    @Size(min=4, max=4, message="图形验证码有误,长度：4位")
    private String captcha;
}