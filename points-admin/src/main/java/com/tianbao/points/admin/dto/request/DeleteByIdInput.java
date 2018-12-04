package com.tianbao.points.admin.dto.request;

import com.tianbao.points.core.utils.StringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteByIdInput {
    /**
     * 实体对象的id
     */
    @NotNull(message = "缺少id无法获取信息")
    private Long id;

    /**
     * 需要输出的属性id，为空输出全部
     */
    private String outputAttributeIds;
    public List<Long> getOutputAttributeIds(){
        return StringConverter.toList(outputAttributeIds);
    }
}