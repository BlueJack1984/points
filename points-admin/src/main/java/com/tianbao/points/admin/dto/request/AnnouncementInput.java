package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


/**
 * @desc 用户实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementInput {

    /**
     * 公告标题
     */
    @NotBlank(message = "公告标题不能为空")
    private String title;
    /**
     * 公告内容
     */
    @NotBlank(message = "公告内容不能为空")
    private String content;
    /**
     * 公告发布时间
     */
    @NotBlank(message = "公告发布时间不能为空")
    private String publishTime;

    /**
     * Length注解用法
     */
    //@NotEmpty(message = "手机号码不能为空")
    //@Length(min = 11, max = 11, message = "手机号码长度必须为11位")
    //private String phone;
}