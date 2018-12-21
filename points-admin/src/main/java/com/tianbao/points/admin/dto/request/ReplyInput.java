package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @desc 管理员回复
 * @author lushusheng
 * @date 2018-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyInput {

    /**
     * 留言实体id
     */
    @NotNull(message = "留言实体id不能为空")
    private Long id;
    /**
     * 回复内容
     */
    @NotBlank(message = "回复内容不能为空")
    private String reply;

    /**
     * 处理状态
     * 5:表示未处理 6：表示已处理
     */
    @NotNull(message = "处理状态不能为空")
    private Integer status;
}
