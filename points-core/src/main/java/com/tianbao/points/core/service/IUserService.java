package com.tianbao.points.core.service;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import javax.persistence.criteria.CriteriaBuilder;
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
     * @Desc 获取管理员的个人档案资料，包装了职位和角色信息
     * @return 返回查询数据
     * @update
     */
    UserDTO getPersonalInfo(Long id)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的登录密码，这里不是指超级密码
     * @param currentId 当前用户id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @param sureNewPassword 确认新密码
     * @return 无返回，操作错误抛出异常
     * @update
     */
    void updatePassword(Long currentId, String oldPassword, String newPassword, String sureNewPassword)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的超级密码，这个用户只有一个，顶级管理员，所以要先判断身份
     * @param currentId 当前用户id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @param sureNewPassword 确认新密码
     * @return 无返回，操作错误抛出异常
     * @update
     */
    void updateSuperPassword(Long currentId, String oldPassword, String newPassword, String sureNewPassword)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 根据用户id集合查询用户列表,分页实现，用于个人积分增值属性
     * @return 返回查询数据列表
     * @update
     */
    List<User> getListByIds(List<Long> ids)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取所有合法用户列表，不分页
     * @return 返回查询到的数据列表
     * @update
     */
    List<UserDTO> getList()throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取所有合法用户列表，分页
     * @param pageNo 表示当前页码
     * @param pageSize 表示数据条数
     * @return 返回查询到的数据列表
     * @update
     */
    PageInfo<UserDTO> getListPage(Integer pageNo, Integer pageSize)throws ApplicationException;
    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 通过会员id查询会员信息
     * @param id 输入的会员id
     * @return 返回会员实体信息
     * @update
     */
    UserDTO getById(Long id)throws ApplicationException;

    /**
     * @desc 根据会员id重置会员密码，设置为一个通用值
     * @author lushusheng 2018-12-02
     * @param id 会员id
     * @param currentId 当前用户id
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    void resetPassword(Long id, Long currentId)throws ApplicationException;

    /**
     * @desc 按条件查询会员
     * @author lushusheng 2018-12-02
     * @param type 按照何种方式进行查询：0表示按照会员id
     * 1表示按照联系方式（手机号） 2表示按照真实姓名查询
     * @param keyword 搜索关键字
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回会员信息
     * @throws ApplicationException 保存异常
     */
    PageInfo<UserDTO> getListByConditionPage(Integer type, String keyword, Integer pageNo, Integer pageSize) throws ApplicationException;

    /**
     * @desc 查询管理员列表，分页展示
     * @author lushusheng 2018-12-03
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回管理员列表信息
     * @throws ApplicationException 保存异常
     */
    PageInfo<UserDTO> getAdminListPage(Integer pageNo, Integer pageSize)throws ApplicationException;

    /**
     * @desc 根据id删除特定管理员信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 实体id
     * @return 返回操作结果
     * @throws ApplicationException 删除异常
     */
    void deleteById(Long id, Long currentId) throws ApplicationException;
}
