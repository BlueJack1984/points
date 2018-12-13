package com.tianbao.points.core.service;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.PersonalBonusDTO;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;


/**
 * @desc 个人积分增值服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IPersonalBonusService extends IBaseService<PersonalBonus, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据系统积分增值id分页查询个人积分增值列表
     * @param sysBonusId 表示要取得数据条数
     * @param pageNo 表示要取得数据条数
     * @param pageSize 表示要取得数据条数
     * @return 返回查询到的数据列表，分页展示
     * @update
     */
    PageInfo<PersonalBonusDTO> getListBySysBonusIdPage(Long sysBonusId, Integer pageNo, Integer pageSize)throws ApplicationException;
    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 设置个人积分增值数据在客户端是否可见
     * @param id 表示实体id
     * @param currentId 表示当前用户id
     * @return 无返回，操作失败抛出异常
     * @update
     */
    void setVisibility(Long id, Long currentId)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据系统积分增值id分页查询个人积分增值列表
     * @param sysBonusId 表示要取得数据条数
     * @return 返回查询到的数据列表
     * @update
     */
    List<PersonalBonus> getListBySysBonusId(Long sysBonusId)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据个人积分增值id集合批量更新实体
     * @param personalBonusList 表示根据人积分增值id批量更新实体
     * @return 无返回，操作失败抛出异常
     * @update
     */
    void updateBatch(List<PersonalBonus> personalBonusList)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据用户id集合批量查询个人积分列表
     * @param userIds 表示用户id集合
     * @return 返回查询到的集合数据
     * @update
     */
    List<PersonalBonus> getListByUserIds(List<Long> userIds)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据个人积分增值id集合批量插入实体
     * @param personalBonusList 表示根据人积分增值id批量插入实体
     * @return 无返回，操作失败抛出异常
     * @update
     */
    void insertBatch(List<PersonalBonus> personalBonusList)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 个人积分列表中查询特定会员积分数据,模糊查询，分页展示
     * @param keyword 输入关键词
     * @param sysBonusId 表示系统积分增值id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回操查询到的数据
     * @update
     */
    PageInfo<PersonalBonusDTO> getByCondition(String keyword, Long sysBonusId, Integer pageNo, Integer pageSize)throws ApplicationException;


    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据会员id获取个人积分列表数据
     * @param userId 表示系统积分增值id
     * @return 返回操查询到的数据
     * @update
     */
    List<PersonalBonus> getPersonalListByUserId(Long userId)throws ApplicationException;
}
