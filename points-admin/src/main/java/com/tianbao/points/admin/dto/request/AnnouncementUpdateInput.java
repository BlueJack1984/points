package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @desc 管首页公告更新信息输入实体
 * @author lushusheng
 * @date 2018-12-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementUpdateInput extends AnnouncementInput{

    /**
     * 首页公告实体id
     */
    @NotNull(message="首页公告实体id不能为空")
    private Long id;
}
