package com.tianbao.points.core.dto;


import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.entity.User;
import lombok.Data;

/**
 * 用户的传输实体
 * 包装用户的相关属性
 * @author lushusheng 2018-11-28
 */
@Data
public class MessageDTO extends Message {

    /**
     * 包装用户属性
     */
    private User user;
}
