package com.tianbao.points.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dao.IPersonalBonusDao;
import com.tianbao.points.core.dto.PersonalBonusDTO;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.BeanHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc 个人积分增值服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class PersonalBonusServiceImpl implements IPersonalBonusService {
    /**
     * 注入个人积分增值dao
     */
    private final IPersonalBonusDao iPersonalBonusDao;
    /**
     * 注入个人信息service
     */
    private final IUserService userServer;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(PersonalBonus record) throws ApplicationException {

    }

    @Override
    public void saveSelective(PersonalBonus record) throws ApplicationException {

    }

    @Override
    public PersonalBonus selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(PersonalBonus record) throws ApplicationException {

    }

    @Override
    public void updateById(PersonalBonus record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据系统积分增值id分页查询个人积分增值列表
     * @param sysBonusId 表示要取得数据条数
     * @param pageNo 表示要取得数据条数
     * @param pageSize 表示要取得数据条数
     * @return 返回查询到的数据列表,正序排列，最新的num条
     * @update
     */
    @Override
    public PageInfo<PersonalBonusDTO> getListBySysBonusIdPage(Long sysBonusId, Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<PersonalBonus> personalBonusList = iPersonalBonusDao.selectListBySysBonusIdPage(sysBonusId);
        List<Long> userIds = new ArrayList<>();
        for(PersonalBonus personalBonus: personalBonusList) {
            userIds.add(personalBonus.getUserId());
        }
        List<User> userList = userServer.getListByIdsPage(userIds);
        List<PersonalBonusDTO> personalBonusDTOList = new ArrayList<>();
        for(PersonalBonus personalBonus: personalBonusList) {
            PersonalBonusDTO personalBonusDTO = new PersonalBonusDTO();
            BeanHelper.copyProperties(personalBonusDTO, personalBonus);
            for(User user: userList) {
                if(user.getId().equals(personalBonus.getUserId())) {
                    BeanHelper.copyProperties(personalBonusDTO.getUserDTO(), user);
                    break;
                }
            }
            personalBonusDTOList.add(personalBonusDTO);
        }
        PageInfo<PersonalBonusDTO> pageInfo = new PageInfo<>(personalBonusDTOList);
        return pageInfo;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 设置个人积分增值数据在客户端是否可见
     * @param id 表示实体id
     * @param currentId 表示当前用户id
     * @return 无返回，操作失败抛出异常
     * @update
     */
    @Transactional
    @Override
    public void setVisibility(Long id, Long currentId) throws ApplicationException {
        PersonalBonus personalBonus = iPersonalBonusDao.selectByPrimaryKey(id);
        if(personalBonus == null) {
            throw new ApplicationException(1,"id参数传输错误");
        }
        //操作一次，取反一次，0表示可见，1表示不可见
        if(personalBonus.getVisible() == 0) {
            personalBonus.setVisible(1);
        }else {
            personalBonus.setVisible(0);
        }
        personalBonus.setUpdateUserId(currentId);
        personalBonus.setUpdateTime(new Date());
        iPersonalBonusDao.updateByPrimaryKey(personalBonus);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据系统积分增值id分页查询个人积分增值列表
     * @param sysBonusId 表示要取得数据条数
     * @return 返回查询到的数据列表
     * @update
     */
    @Override
    public List<PersonalBonus> getListBySysBonusId(Long sysBonusId) throws ApplicationException {
        //这里服用分页的方法进行查询，但实际不分页
        List<PersonalBonus> personalBonusList = iPersonalBonusDao.selectListBySysBonusIdPage(sysBonusId);
        return personalBonusList;
    }
    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据个人积分增值id集合批量更新实体
     * @param personalBonusList 表示根据人积分增值id批量更新实体
     * @return 无返回，操作失败抛出异常
     * @update
     */
    @Override
    public void updateBatch(List<PersonalBonus> personalBonusList) throws ApplicationException {
        iPersonalBonusDao.updateBatch(personalBonusList);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据用户id集合批量查询个人积分列表
     * @param userIds 表示用户id集合
     * @return 返回查询到的集合数据
     * @update
     */
    @Override
    public List<PersonalBonus> getListByUserIds(List<Long> userIds) throws ApplicationException {
        List<PersonalBonus> personalBonusList = iPersonalBonusDao.getListByUserIds(userIds);
        return personalBonusList;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据个人积分增值id集合批量插入实体
     * @param personalBonusList 表示根据人积分增值id批量插入实体
     * @return 无返回，操作失败抛出异常
     * @update
     */
    @Override
    public void insertBatch(List<PersonalBonus> personalBonusList) throws ApplicationException {
        iPersonalBonusDao.insertBatch(personalBonusList);
    }
}
