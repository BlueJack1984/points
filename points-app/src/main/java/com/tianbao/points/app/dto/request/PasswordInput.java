package com.tianbao.points.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @desc 修改密码的输入实体
 * @author lushusheng
 * @date 2018-11-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordInput {

    /**
     * 以前的原密码
     */
    @NotBlank(message="原密码不能为空")
    @Size(min=6, max=18, message="密码长度有误,长度应为：6-18位")
    private String oldPassword;

    /**
     * 输入的新密码
     */
    @NotBlank(message="新密码不能为空")
    @Size(min=6, max=18, message="密码长度有误,长度应为：6-18位")
    private String newPassword;

    /**
     * 重复输入的新密码
     */
    @NotBlank(message="重复新密码不能为空")
    @Size(min=6, max=18, message="密码长度有误,长度应为：6-18位")
    private String sureNewPassword;
}
