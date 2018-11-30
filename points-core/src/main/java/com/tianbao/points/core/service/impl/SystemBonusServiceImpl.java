package com.tianbao.points.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dao.ISystemBonusDao;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.ISystemBonusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @return 返回无，出错抛出异常
     * @update
     */
    @Override
    public void deleteById(Long id) throws ApplicationException {
        SystemBonus systemBonus = iSystemBonusDao.selectByPrimaryKey(id);
        if(systemBonus == null) {
            throw new ApplicationException(1, "无法删除，参数错误");
        }
        //逻辑删除，将status状态值置为1
        systemBonus.setStatus(1);
        systemBonus.setUpdateTime(new Date());
        //无法把updateUserId赋值
        iSystemBonusDao.updateByPrimaryKey(systemBonus);
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

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 设置系统积分增值数据在客户端是否可见
     * @param id 表示系统积分增值id
     * @param currentId 表示当前用户id
     * @return 返回操作结果，操作失败则抛出异常
     * @update
     */
    @Transactional
    @Override
    public void setVisibility(Long id, Long currentId) throws ApplicationException {
        SystemBonus systemBonus = iSystemBonusDao.selectByPrimaryKey(id);
        if(systemBonus == null) {
            throw new ApplicationException(1,"id参数传输错误");
        }
        //操作一次，取反一次，0表示可见，1表示不可见
        if(systemBonus.getVisible() == 0) {
            systemBonus.setVisible(1);
        }else {
            systemBonus.setVisible(0);
        }
        systemBonus.setUpdateUserId(currentId);
        systemBonus.setUpdateTime(new Date());
        iSystemBonusDao.updateByPrimaryKey(systemBonus);
    }
}
