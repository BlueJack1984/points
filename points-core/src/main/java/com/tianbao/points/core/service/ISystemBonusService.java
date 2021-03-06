package com.tianbao.points.core.service;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.response.SystemBonusOutput;
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

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 设置系统积分增值数据在客户端是否可见
     * @param id 表示系统积分增值id
     * @param currentId 表示当前用户id
     * @return 返回操作结果，操作失败则抛出异常
     * @update
     */
    void setVisibility(Long id, Long currentId)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 计算当前系统的总积分并生成系统权重比率系数
     * @return 返回系统积分输出属性实体SystemBonusOutput
     * @update
     */
    SystemBonusOutput balance()throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 结算当日系统总积分和个人总积分
     * 判断同一天不能多次结算，最多一次
     * 批量插入个人积分增值数据
     * @param systemRatio 系统权重比率
     * @param currentId 当前管理员id
     * @return 无返回
     * @update
     */
    void checkout(Double systemRatio, Long currentId)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取数据库中最新的一条系统积分结算信息，主要用于比对日期
     * @return 返回系查询到的实体信息
     * @update
     */
    SystemBonus getLatest()throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @param id 实体id
     * @param currentId 管理员id
     * @return 返回无，出错抛出异常
     * @update
     */
    void deleteById(Long id, Long currentId) throws ApplicationException;
}
