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
}