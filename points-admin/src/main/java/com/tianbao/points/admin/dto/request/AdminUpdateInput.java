package com.tianbao.points.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;


/**
 * @desc 管理员更新信息输入实体
 * @author lushusheng
 * @date 2018-12-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateInput extends AdminInput{

    /**
     * 管理员用户id
     */
    @NotNull(message=" 管理员用户id不能为空")
    private Long id;
}
