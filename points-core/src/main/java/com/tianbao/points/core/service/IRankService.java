package com.tianbao.points.core.service;


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
}

