package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.entity.ConsumeRecord;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IConsumeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 权限服务接口
 * @author lushusheng
 * @date 2018-12-18
 *
 */
@Service
@RequiredArgsConstructor
public class ConsumeRecordServiceImpl implements IConsumeRecordService {
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
}
