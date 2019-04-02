package com.tianbao.points.core.service.impl;


import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.ISystemBonusDao;
import com.tianbao.points.core.dto.PersonalBonusDTO;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.dto.response.SystemBonusOutput;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import com.tianbao.points.core.service.IRankService;
import com.tianbao.points.core.service.ISystemBonusService;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.service.base.VisibilityService;
import com.tianbao.points.core.utils.BeanHelper;
import com.tianbao.points.core.utils.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @desc 系统积分增值服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class SystemBonusServiceImpl extends VisibilityService implements ISystemBonusService {
    /**
     * 注入系统积分增值dao
     */
    private final ISystemBonusDao iSystemBonusDao;
    /**
     * 注入个人积分增值service
     */
    private final IPersonalBonusService personalBonusServer;
    /**
     * 注入用户service
     */
    private final IUserService userServer;
    /**
     * 注入会员等级service
     */
    private final IRankService rankServer;


    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @return 返回无，出错抛出异常
     * @update
     */
    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(SystemBonus record) throws ApplicationException {
        iSystemBonusDao.insertMigration(record);
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
            throw new ApplicationException(ApplicationException.SYSTEM_BONUS_NOT_EXISTS,"系统积分实体不存在");
        }
        change(systemBonus, currentId);
        iSystemBonusDao.updateByPrimaryKey(systemBonus);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 计算当前系统的总积分并生成系统权重比率系数
     * @return 返回系统积分输出属性实体SystemBonusOutput
     * @update
     */
    @Override
    public SystemBonusOutput balance() throws ApplicationException {

//        List<UserDTO> userDTOList = loadAllUsers();
        SystemBonusOutput systemBonusOutput = new SystemBonusOutput();
//        Double totalPoints = 0.0;
//        for(UserDTO userDTO: userDTOList) {
//            if(userDTO.getPersonalBonus() == null) {
//                continue;
//            }
//            Double points = userDTO.getPersonalBonus().getEndPoints();
//            if(points != null) {
//                totalPoints += points;
//            }
//        }
//        systemBonusOutput.setTotalPoints(totalPoints);
        SystemBonus systemBonus = iSystemBonusDao.selectLatest();
        if(systemBonus == null) {
            systemBonusOutput.setTotalPoints(0.0);
        }else {
            systemBonusOutput.setTotalPoints(systemBonus.getEndPoints());
        }
        systemBonusOutput.setSystemRatio(RandomGenerator.getRandomRatio());
        return systemBonusOutput;
    }

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 结算当日系统总积分和个人总积分
     * 判断同一天不能多次结算，最多一次
     * 批量插入个人积分增值数据
     * @param systemRatio 系统权重比率
     * @param currentId 当前管理员id
     * @return 无返回
     * @update
     */
    @Override
    public void checkout(Double systemRatio, Long currentId) throws ApplicationException {
        List<UserDTO> userDTOList = loadAllUsers();
        List<PersonalBonus> personalBonusList = new ArrayList<>();
        Double startPoints = 0.0;
        Double endPoints = 0.0;
        for(UserDTO userDTO: userDTOList) {
            if(userDTO.getPersonalBonus() == null) {
                PersonalBonus headBonus = new PersonalBonus();
                headBonus.setId(0L);
                headBonus.setStartPoints(0.0);
                Rank rank = userDTO.getRank();
                if(rank == null) {
                    throw new ApplicationException(ApplicationException.RANK_NOT_EXISTS, "该用户没有设定会员等级");
                }else if (rank.getOrder() < 1 || rank.getOrder() > 4){
                    throw new ApplicationException(ApplicationException.PARAM_VALIDATION_ERROR, "会员等级参数错误");
                }
                headBonus.setEndPoints(1.0 * rank.getBasePoints());
                userDTO.setPersonalBonus(headBonus);
                //continue;
            }
            PersonalBonus personalBonus = new PersonalBonus();
            personalBonus.setId(IdWorker.getId());
            personalBonus.setParentId(userDTO.getPersonalBonus().getId());
            personalBonus.setStartPoints(userDTO.getPersonalBonus().getEndPoints());
            personalBonus.setUserId(userDTO.getId());
            personalBonus.setVisible(0);
            personalBonus.setRatio(systemRatio);
            personalBonus.setStatus(StatusCode.NORMAL.getCode());
            personalBonus.setCreateUserId(currentId);
//            String string = "2019-03-24 21:59:06";
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date wantedDate = null;
//            try {
//                wantedDate = sdf.parse(string);
//            }catch (Exception ex) {
//                System.out.println("************************日期格式转换错误******************");
//            }
//            personalBonus.setCreateTime(wantedDate);
//            personalBonus.setUpdateTime(wantedDate);
            personalBonus.setCreateTime(new Date());
            personalBonus.setUpdateTime(new Date());
            personalBonus.setUpdateUserId(currentId);
            startPoints += userDTO.getPersonalBonus().getEndPoints();
            Double points = userDTO.getPersonalBonus().getEndPoints() + userDTO.getRank().getBasePoints() * systemRatio;
            personalBonus.setEndPoints(points);
            endPoints += points;
            personalBonusList.add(personalBonus);
        }
        Long systemBonusId = saveSystemBonus(startPoints, endPoints, systemRatio, currentId);
        savePersonalBonusList(systemBonusId, personalBonusList);
    }

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 获取数据库中最新的一条系统积分结算信息，主要用于比对日期
     * @return 返回系查询到的实体信息
     * @update
     */
    @Override
    public SystemBonus getLatest() throws ApplicationException {
        SystemBonus systemBonus = iSystemBonusDao.selectLatest();
        return systemBonus;
    }

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @param id 实体id
     * @param currentId 管理员id
     * @return 返回无，出错抛出异常
     * @update
     */
    @Override
    public void deleteById(Long id, Long currentId) throws ApplicationException {
        SystemBonus systemBonus = iSystemBonusDao.selectByPrimaryKey(id);
        if(systemBonus == null) {
            throw new ApplicationException(ApplicationException.SYSTEM_BONUS_NOT_EXISTS, "系统积分实体不存在");
        }
        //逻辑删除，将status状态值置为禁用
        systemBonus.setStatus(StatusCode.FORBIDDEN.getCode());
        systemBonus.setUpdateTime(new Date());
        systemBonus.setUpdateUserId(currentId);
        iSystemBonusDao.updateByPrimaryKey(systemBonus);
        //还要把与这个关联的个人积分增值的属性system_bonus_id清空
        List<PersonalBonus> personalBonusList = personalBonusServer.getListBySysBonusId(id);
        if(personalBonusList == null || personalBonusList.size() <= 0) {
            return;
        }
        for(PersonalBonus personalBonus: personalBonusList) {
            personalBonus.setSystemBonusId(null);
            personalBonus.setStatus(StatusCode.FORBIDDEN.getCode());
            personalBonus.setUpdateTime(new Date());
            personalBonus.setUpdateUserId(currentId);
        }
        personalBonusServer.updateBatch(personalBonusList);
    }

    @Transactional
    public Long saveSystemBonus(Double startPoints, Double endPoints, Double systemRatio, Long currentId)throws ApplicationException {
        SystemBonus systemBonus = new SystemBonus();
        systemBonus.setStartPoints(startPoints);
        systemBonus.setEndPoints(endPoints);
        systemBonus.setRatio(systemRatio);
        systemBonus.setVisible(0);
        systemBonus.setStatus(StatusCode.NORMAL.getCode());
//        String string = "2019-03-24 21:59:06";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date wantedDate = null;
//        try {
//            wantedDate = sdf.parse(string);
//        }catch (Exception ex) {
//            System.out.println("************************日期格式转换错误******************");
//        }
//        systemBonus.setCreateTime(wantedDate);
//        systemBonus.setUpdateTime(wantedDate);
        systemBonus.setCreateTime(new Date());
        systemBonus.setCreateUserId(currentId);
        systemBonus.setUpdateTime(new Date());
        systemBonus.setUpdateUserId(currentId);
        iSystemBonusDao.insert(systemBonus);
        return systemBonus.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public void savePersonalBonusList(Long systemBonusId, List<PersonalBonus> personalBonusList)throws ApplicationException {
        for(PersonalBonus personalBonus: personalBonusList) {
            personalBonus.setSystemBonusId(systemBonusId);
        }
        personalBonusServer.insertBatch(personalBonusList);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 计算当前系统的总积分并生成系统权重比率系数
     * @return 返回系统积分输出属性实体SystemBonusOutput
     * @update
     */
    private List<UserDTO> loadAllUsers() throws ApplicationException {
        //获取所有合法用户列表,包含会员等级信息
        List<UserDTO> userDTOList = userServer.getList();
        if (userDTOList == null) {
            throw new ApplicationException(ApplicationException.MEMBER_USER_NOT_EXISTS, "已审核会员用户列表为空");
        }
        List<Long> userIds = new ArrayList<>();
        for(UserDTO userDTO: userDTOList) {
            userIds.add(userDTO.getId());
        }
        //根据用户id列表查询最新个人积分列表
        List<PersonalBonus> personalBonusList = personalBonusServer.getListByUserIds(userIds);
        for (UserDTO userDTO : userDTOList) {
            for (PersonalBonus personalBonus : personalBonusList) {
                if (userDTO.getId().equals(personalBonus.getUserId())) {
                    userDTO.setPersonalBonus(personalBonus);
                    break;
                }
            }
        }
        return userDTOList;
    }
}
