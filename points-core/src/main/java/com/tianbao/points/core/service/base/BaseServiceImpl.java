package com.tianbao.points.core.service.base;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc 基本服务接口
 * @author lushusheng
 * @date 2018-11-21
 * 这个实现类在项目中没有用到，只是作为备用
 */
@RequiredArgsConstructor
public abstract class BaseServiceImpl<K, T> {

    private final IBaseDao<K, T> iBaseDao;
    private static final Logger logger = LoggerFactory.getLogger(IBaseService.class);

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @return 返回无，出错抛出异常
     * @update
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(T id) throws ApplicationException {
        try {
            iBaseDao.deleteByPrimaryKey(id);
        }catch(Exception e) {
            logger.info(e.getMessage());
            throw new ApplicationException();
        }
    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 保存一个实体数据
     * @return 返回无，出错抛出异常
     * @update
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(K record) throws ApplicationException {
        try {
            iBaseDao.insert(record);
        }catch(Exception e) {
            logger.info(e.getMessage());
            throw new ApplicationException();
        }
    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 插入一个实体数据，非空数据才执行插入操作
     * @return 返回无，出错抛出异常
     * @update
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveSelective(K record) throws ApplicationException {
        try {
            iBaseDao.insertSelective(record);
        }catch(Exception e) {
            logger.info(e.getMessage());
            throw new ApplicationException();
        }
    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id查询实体数据
     * @return 返回查询到的实体
     * @update
     */
    public K selectById(T id) throws ApplicationException {
        try {
            return iBaseDao.selectByPrimaryKey(id);
        }catch(Exception e) {
            logger.info(e.getMessage());
            throw new ApplicationException();
        }
    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id更新实体数据，只更新非空数据
     * @return 返回无，出错抛出异常
     * @update
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateByIdSelective(K record) throws ApplicationException {
        try {
            iBaseDao.updateByPrimaryKeySelective(record);
        }catch(Exception e) {
            logger.info(e.getMessage());
            throw new ApplicationException();
        }
    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id更新实体数据，不管数据是否为空都更新覆盖
     * @return 返回无，出错抛出异常
     * @update
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateById(K record) throws ApplicationException {
        try {
            iBaseDao.updateByPrimaryKeySelective(record);
        }catch(Exception e) {
            logger.info(e.getMessage());
            throw new ApplicationException();
        }
    }
}
