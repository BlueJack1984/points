package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @desc 会员用户角色关联输入实体
 * @author lushusheng
 * @date 2019-1-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleMigrationInput {

    /**
     * 会员用户id
     */
    @NotNull(message = "会员用户id参数不能为空")
    private Long userId;
    /**
     * 角色id
     */
    @NotNull(message = "角色id参数不能为空")
    private Long roleId;

}
