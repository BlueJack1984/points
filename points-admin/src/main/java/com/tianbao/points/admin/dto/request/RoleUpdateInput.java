package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @desc 更新角色数据的属性
 * @author lushusheng
 * @date 2018-12-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleUpdateInput extends RoleInput{

    /**
     * 角色实体id
     */
    @NotEmpty(message = "角色实体id不能为空")
    private Long id;
}
