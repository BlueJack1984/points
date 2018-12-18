package com.tianbao.points.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dao.IConsumeRecordDao;
import com.tianbao.points.core.entity.ConsumeRecord;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IConsumeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 权限服务接口
 * @author lushusheng
 * @date 2018-12-18
 *
 */
@Service
@RequiredArgsConstructor
public class ConsumeRecordServiceImpl implements IConsumeRecordService {

    private final IConsumeRecordDao iConsumeRecordDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(ConsumeRecord record) throws ApplicationException {

    }

    @Override
    public void saveSelective(ConsumeRecord record) throws ApplicationException {

    }

    @Override
    public ConsumeRecord selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(ConsumeRecord record) throws ApplicationException {

    }

    @Override
    public void updateById(ConsumeRecord record) throws ApplicationException {

    }

    /**
     * @desc 获取消费记录列表,分页展示
     * @author lushusheng 2018-12-17
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @param currentId 当前用户id
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    @Override
    public PageInfo<ConsumeRecord> getListPage(Integer pageNo, Integer pageSize, Long currentId) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<ConsumeRecord> consumeRecordList = iConsumeRecordDao.getListPage(currentId);
        PageInfo<ConsumeRecord> pageInfo = new PageInfo<>(consumeRecordList);
        return pageInfo;
    }
}
