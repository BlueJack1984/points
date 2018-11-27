package com.tianbao.points.core.dao.base;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author lushusheng
 * @Date 2018-11-19
 * @Desc 持久层基本增删改查接口
 */
@Mapper
public interface BaseDao<K, T> {

    /**
     * @author lushusheng
     * @Date 2018-11-19
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @return 返回数据库受影响的行数
     * @update
     */
    int deleteByPrimaryKey(T id);

    /**
     * @author lushusheng
     * @Date 2018-11-19
     * @Desc 插入一个实体数据
     * @return 返回数据库受影响的行数
     * @update
     */
    int insert(K record);

    /**
     * @author lushusheng
     * @Date 2018-11-19
     * @Desc 插入一个实体数据，非空数据才执行插入操作
     * @return 返回数据库受影响的行数
     * @update
     */
    int insertSelective(K record);

    /**
     * @author lushusheng
     * @Date 2018-11-19
     * @Desc 根据id查询实体数据
     * @return 返回查询到的实体
     * @update
     */
    K selectByPrimaryKey(T id);

    /**
     * @author lushusheng
     * @Date 2018-11-19
     * @Desc 根据id更新实体数据，只更新非空数据
     * @return 返回数据库受影响的行数
     * @update
     */
    int updateByPrimaryKeySelective(K record);

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id更新实体数据，不管数据是否为空都更新覆盖
     * @return 返回数据库受影响的行数
     * @update
     */
    int updateByPrimaryKey(K record);

}
