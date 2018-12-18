package com.tianbao.points.core.service;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.entity.ConsumeRecord;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

/**
 * @desc 消费记录服务接口
 * @author lushusheng
 * @date 2018-12-17
 *
 */
public interface IConsumeRecordService extends IBaseService<ConsumeRecord, Long> {

    /**
     * @desc 获取消费记录列表,分页展示
     * @author lushusheng 2018-12-17
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @param currentId 当前用户id
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    PageInfo<ConsumeRecord> getListPage(Integer pageNo, Integer pageSize, Long currentId)throws ApplicationException;

}
