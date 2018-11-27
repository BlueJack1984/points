package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @desc 用户留言关联表实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_message")
public class UserMessage extends ObjectPO<Long> {

    /**
     * 留言的id
     */
    private Long messageId;
    /**
     * 发送者id
     */
    private Long senderId;
    /**
     * 接收者id
     */
    private Long receiverId;
}