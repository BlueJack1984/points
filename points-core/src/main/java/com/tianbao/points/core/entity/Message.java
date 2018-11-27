package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * @desc 留言实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "message")
public class Message extends ObjectPO<Long> {

    /**
     * 留言标题
     */
    private String title;
    /**
     * 留言内容
     */
    private String content;
    /**
     * 留言可能存在的url类型
     */
    private Integer urlType;
    /**
     * 留言可能存在的url地址
     */
    private String url;
    /**
     * 留言的回复
     */
    private String reply;
}