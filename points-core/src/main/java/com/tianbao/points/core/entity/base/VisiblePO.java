package com.tianbao.points.core.entity.base;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 定义中间层持久化对象
 * @author lushusheng
 * @date 2018-12-08
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class VisiblePO<K> extends ObjectPO<K> {

    /**
     * 此数据是否对会员客户端可见，0表示正常可见，1表示不可见
     */
    protected Integer visible;
}
