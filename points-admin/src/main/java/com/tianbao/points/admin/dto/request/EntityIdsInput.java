package com.tianbao.points.admin.dto.request;

import com.tianbao.points.core.utils.StringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @desc 操作的用户实体ids
 * @author lushusheng
 * @date 2018-12-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityIdsInput {

    /**
     * 需要输出的属性id，为空输出全部
     */
    @NotBlank(message = "实体ids集合参数不能为空")
    private String ids;
    /**
     * @desc 获取实体id的列表
     * @author lushusheng
     * @date 2018-12-12
     */
    public List<Long> getIdList(){
        return StringConverter.toList(ids);
    }
}