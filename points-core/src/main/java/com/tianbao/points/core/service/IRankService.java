package com.tianbao.points.core.service;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 会员等级服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IRankService extends IBaseService<Rank, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-01
     * @Desc 查询会员等级列表，不分页
     * @return 返回会员等级集合数据
     * @update
     */
    List<Rank> getList()throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 查询会员等级列表，分页
     * @param pageNo 表示当前页码
     * @param pageSize 表示数据条数
     * @return 返回会员等级集合数据
     * @update
     */
    PageInfo<Rank> getListPage(Integer pageNo, Integer pageSize)throws ApplicationException;

    /**
     * @desc 新建保存会员等级数据
     * @author lushusheng 2018-12-05
     * @param currentId 当前管理员用户id
     * @param rank 要保存的实体参数
     * @return 返回保存数据
     * @throws ApplicationException 保存异常
     */
    Rank insert(Rank rank, Long currentId)throws ApplicationException;
}

