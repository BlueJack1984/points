package com.tianbao.points.core.service.base;

import com.tianbao.points.core.exception.ApplicationException;

/**
 * @desc 基本服务接口
 * @author lushusheng
 * @date 2018-11-21
 *
 */

public interface IBaseService<K, T> {

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @return 返回无，出错抛出异常
     * @update
     */
    void deleteById(T id) throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 保存一个实体数据
     * @return 返回无，出错抛出异常
     * @update
     */
    void save(K record) throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 插入一个实体数据，非空数据才执行插入操作
     * @return 返回无，出错抛出异常
     * @update
     */
    void saveSelective(K record) throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id查询实体数据
     * @return 返回查询到的实体
     * @update
     */
    K selectById(T id) throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id更新实体数据，只更新非空数据
     * @return 返回无，出错抛出异常
     * @update
     */
    void updateByIdSelective(K record) throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id更新实体数据，不管数据是否为空都更新覆盖
     * @return 返回无，出错抛出异常
     * @update
     */
    void updateById(K record) throws ApplicationException;
}
