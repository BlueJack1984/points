package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.ConsumeRecord;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.exception.ApplicationException;
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
     * @desc 获取消费记录列表,分页展示
     * @author lushusheng 2018-12-17
     * @param userId 当前用户id
     * @return 返回实体数据列表
     */
    List<ConsumeRecord> getListPage(@Param("userId") Long userId);
}