package com.tianbao.points.core.service;

import com.tianbao.points.core.entity.Department;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 部门服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IDepartmentService extends IBaseService<Department, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据部门的id集合查询部门列表,个人档案部分使用
     * @param ids 部门的id集合
     * @return 返回部门列表
     * @update
     */
    List<Department> getListByIds(List<Long> ids)throws ApplicationException;
}
