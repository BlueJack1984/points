package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.ConsumeRecord;
import com.tianbao.points.core.entity.Rank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-12-17
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IConsumeRecordDao extends IBaseDao<ConsumeRecord, Long> {

    /**
     * @desc 通过排序编号查询会员等级
     * @author lushusheng 2018-12-05
     * @param order 排序编号
     * @return 返回查询到的数据
     */
    //Rank getByOrder(@Param("order") Integer order);
}