package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @desc 留言输入实体
 * @author lushusheng
 * @date 2018-12-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityMigrationInput {

    /**
     * 留言标题
     */
    @NotBlank(message = "留言标题参数不能为空")
    private String title;
}
