package com.tianbao.points.core.dto;


import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.entity.UserMessage;
import lombok.Data;

/**
 * 用户留言的传输实体
 * 包装用户和留言的相关属性
 * @author lushusheng 2018-11-28
 */
@Data
public class UserMessageDTO extends UserMessage {

    /**
     * 包装用户实体
     *
     */
    private User user;
    /**
     * 包装留言实体
     *
     */
    private Message message;
}
