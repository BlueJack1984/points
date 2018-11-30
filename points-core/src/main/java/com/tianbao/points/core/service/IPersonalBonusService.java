package com.tianbao.points.core.service;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.PersonalBonusDTO;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;


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
}
