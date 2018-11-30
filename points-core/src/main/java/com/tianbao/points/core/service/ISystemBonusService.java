package com.tianbao.points.core.service;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

/**
 * @desc 系统积分增值服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface ISystemBonusService extends IBaseService<SystemBonus, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询系统积分增值列表，分页倒叙查询
     * @param pageNo 表示当前页面
     * @param pageSize 表示页面显示数据条数
     * @return 返回查询到系统积分增值相关列表
     * @update
     */
    PageInfo<SystemBonus> getListPage(Integer pageNo, Integer pageSize)throws ApplicationException;
}
