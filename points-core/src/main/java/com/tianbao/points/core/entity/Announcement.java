package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Table;
import java.util.Date;

/**
 * @desc 首页公告实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "announcement")
public class Announcement extends ObjectPO<Long> {

    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 发布者id
     */
    private Long userId;
    /**
     * 公告发布时间
     */
    private Date publishTime;
}