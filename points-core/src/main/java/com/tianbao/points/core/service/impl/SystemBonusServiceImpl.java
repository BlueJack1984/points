package com.tianbao.points.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dao.ISystemBonusDao;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.ISystemBonusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void save(SystemBonus record) throws ApplicationException {

    }

    @Override
    public void saveSelective(SystemBonus record) throws ApplicationException {

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

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询系统积分增值列表，分页倒叙查询
     * @param pageNo 表示当前页面
     * @param pageSize 表示页面显示数据条数
     * @return 返回查询到系统积分增值相关列表
     * @update
     */
    @Override
    public PageInfo<SystemBonus> getListPage(Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<SystemBonus> systemBonusList = iSystemBonusDao.getListPage();
        PageInfo<SystemBonus> pageInfo = new PageInfo<>(systemBonusList);
        return pageInfo;
    }
}
