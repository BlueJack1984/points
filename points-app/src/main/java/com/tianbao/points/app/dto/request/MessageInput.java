package com.tianbao.points.app.dto.request;


import com.tianbao.points.core.utils.StringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @desc 留言输入实体
 * @author lushusheng
 * @date 2018-12-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInput {

    /**
     * 留言标题
     */
    @NotBlank(message = "留言标题参数不能为空")
    private String title;
    /**
     * 留言内容
     */
    @NotBlank(message = "留言内容参数不能为空")
    private String content;
    /**
     * 当前用户发送该留言
     * 需要接收该留言的用户id集合，id之间使用逗号进行分隔
     * 做为一个字符串进行传输
     */
    @NotBlank(message = "接收用户ids集合参数不能为空")
    private String ids;
    /**
     * @desc 获取接收用户id的列表
     * @author lushusheng
     * @date 2018-12-17
     */
    public List<Long> getIdList(){
        return StringConverter.toList(ids);
    }
}
