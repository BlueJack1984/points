package com.tianbao.points.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


/**
 * @desc 证券指数修改输入实体，比保存实体多一个实体id参数
 * @author lushusheng
 * @date 2018-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockUpdateInput extends StockBaseInput{

    /**
     * 修改的实体id
     */
    @NotEmpty(message = "实体id不能为空")
    private Long id;
}
