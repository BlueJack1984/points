package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.PersonalBonus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IPersonalBonusDao extends IBaseDao<PersonalBonus, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据系统积分增值id分页查询个人积分增值列表
     * @param sysBonusId 表示要取得数据条数
     * @return 返回查询到的数据列表
     * @update
     */
    List<PersonalBonus> selectListBySysBonusIdPage(@Param("sysBonusId") Long sysBonusId);

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据个人积分增值id集合批量更新实体
     * @param personalBonusList 表示根据人积分增值id批量更新实体
     * @return 无返回，操作失败抛出异常
     * @update
     */
    void updateBatch(@Param("personalBonusList") List<PersonalBonus> personalBonusList);
    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据用户id集合批量查询个人积分列表
     * @param userIds 表示用户id集合
     * @return 返回查询到的集合数据
     * @update
     */
    List<PersonalBonus> getListByUserIds(@Param("userIds") List<Long> userIds);

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据个人积分增值id集合批量插入实体
     * @param personalBonusList 表示根据人积分增值id批量插入实体
     * @return 无返回，操作失败抛出异常
     * @update
     */
    void insertBatch(@Param("personalBonusList") List<PersonalBonus> personalBonusList);

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 个人积分列表中查询特定会员积分数据,模糊查询，分页展示
     * @param keyword 输入关键词
     * @param sysBonusId 表示系统积分增值id
     * @return 返回操查询到的数据
     * @update
     */
    List<PersonalBonus> getByCondition(@Param("keyword") String keyword, @Param("sysBonusId") Long sysBonusId);

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据会员id获取个人积分列表数据
     * @param userId 表示系统积分增值id
     * @return 返回操查询到的数据
     * @update
     */
    List<PersonalBonus> getPersonalListByUserId(@Param("userId") Long userId);

    /**
     * @author lushusheng
     * @Date 2019-1-30
     * @Desc 根据会员id获取个人积分最新的一条数据
     * @param userId 表示系统积分增值id
     * @return 返回操查询到的一条数据
     * @update
     */
    PersonalBonus getLatestByUserId(@Param("userId") Long userId);

    /**
     * @author lushusheng
     * @Date 2019-2-1
     * @Desc 根据会员id获取个人积分距离当前时间最近一个月内最新的一条数据
     * @param userId 表示用户id
     * @param aMonthTime 表示当前时间往前一个月
     * @return 返回操查询到的一条数据
     * @update
     */
    PersonalBonus getLatestByUserIdInMonth(@Param("userId") Long userId, @Param("aMonthTime") String aMonthTime);
}
