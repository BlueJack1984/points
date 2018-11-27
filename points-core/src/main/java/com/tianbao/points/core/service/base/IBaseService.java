package com.tianbao.points.core.service.base;


import com.tianbao.points.core.dao.base.IBaseDao;
import lombok.RequiredArgsConstructor;

/**
 * @desc 返回实体的属性值
 * @author lushusheng
 * @date 2018-11-21
 * @param code 错误代号值,默认正常返回值200
 * @param message 错误信息，默认正常返回信息"SUCCESS"
 * @param data 返回数据
 */
@RequiredArgsConstructor
public abstract class IBaseService<K, T> {

    private final IBaseDao<K, T> iBaseDao;

}
