package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.ISystemBonusDao;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.ISystemBonusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 系统积分增值服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class SystemBonusServiceImpl implements ISystemBonusService {
    /**
     * 注入系统积分增值dao
     */
    private final ISystemBonusDao iSystemBonusDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public SystemBonus save(SystemBonus record) throws ApplicationException {
        return null;
    }

    @Override
    public SystemBonus saveSelective(SystemBonus record) throws ApplicationException {
        return null;
    }

    @Override
    public SystemBonus selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(SystemBonus record) throws ApplicationException {

    }

    @Override
    public void updateById(SystemBonus record) throws ApplicationException {

    }
}
