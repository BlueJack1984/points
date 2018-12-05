package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @desc 更新会员实体信息
 * @author lushusheng
 * @date 2018-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {

    /**
     * 会员id
     */
    @NotNull(message = "实体id不能为空")
    private Long id;
    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名不能为空")
    private String realName;
    /**
     * 会员级别id
     */
    @NotNull(message = "会员级别id不能为空")
    private Long rankId;
    /**
     * 身份证号
     */
    @NotBlank(message = "身份证号不能为空")
    private String identityNumber;
    /**
     * 手机号
     */
    //@NotBlank(message = "手机号不能为空")
    private String phone;
    /**
     * 省级
     */
    //@NotBlank(message = "省级不能为空")
    private String province;
    /**
     * 市级
     */
    //@NotBlank(message = "省级不能为空")
    private String city;
    /**
     * 详细地址
     */
    //@NotBlank(message = "省级不能为空")
    private String address;
}
