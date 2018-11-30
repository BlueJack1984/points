package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.SystemBonus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface ISystemBonusDao extends IBaseDao<SystemBonus, Long> {
    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询系统积分增值列表，分页倒叙查询
     * @return 返回查询到系统积分增值相关列表
     * @update
     */
    List<SystemBonus> getListPage();
}