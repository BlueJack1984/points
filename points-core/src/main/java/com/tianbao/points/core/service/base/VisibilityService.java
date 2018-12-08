package com.tianbao.points.core.service.base;


import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.entity.base.VisiblePO;
import com.tianbao.points.core.exception.ApplicationException;

import java.util.Date;

/**
 * @desc 设置系统积分和个人积分数据的可见性
 * @author lushusheng
 * @date 2018-12-08
 *
 */
public abstract class VisibilityService {

    /**
     * @author lushusheng
     * @Date 2018-12-08
     * @Desc 设置系统和个人积分增值数据在客户端是否可见
     * @param visiblePO 表示要操作的实体
     * @param currentId 表示当前用户id
     * @return 无返回，操作失败抛出异常
     * @update
     */
    public void change(VisiblePO<Long> visiblePO, Long currentId) throws ApplicationException {
        //操作一次取反一次，0表示可见，1表示不可见
        if(visiblePO.getVisible() == 0) {
            visiblePO.setVisible(StatusCode.FORBIDDEN.getCode());
        }else {
            visiblePO.setVisible(StatusCode.NORMAL.getCode());
        }
        visiblePO.setUpdateUserId(currentId);
        visiblePO.setUpdateTime(new Date());
    }
}
