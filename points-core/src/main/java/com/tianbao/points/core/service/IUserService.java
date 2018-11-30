package com.tianbao.points.core.service;


import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 用户接口，可用于管理员或其他
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IUserService extends IBaseService<User, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取用户的个人档案资料，包装了职位和角色信息
     * @return 返回查询数据
     * @update
     */
    UserDTO getPersonalInfo(Long id)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的登录密码，这里不是指超级密码
     * @return 无返回，操作错误抛出异常
     * @update
     */
    void updatePassword(Long id)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的超级密码，这个用户只有一个，顶级管理员，所以要先判断身份
     * @return 无返回，操作错误抛出异常
     * @update
     */
    void updateSuperPassword(Long id)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 根据用户id集合查询用户列表,分页实现，用于个人积分增值属性
     * @return 返回查询数据列表
     * @update
     */
    List<User> getListByIdsPage(List<Long> ids)throws ApplicationException;

}
