package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IUserDao extends IBaseDao<User, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 根据用户id集合查询用户列表,分页实现，用于个人积分增值属性
     * @return 返回查询数据列表
     * @update
     */
    List<User> getListByIds(@Param("ids") List<Long> ids);

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取所有合法用户列表，不分页
     * @return 返回查询到的数据列表
     * @update
     */
    List<UserDTO> getList();

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 获取所有合法用户列表，分页
     * @return 返回查询到的数据列表
     * @update
     */
    List<User> selectListPage();
    /**
     * @desc 按条件查询会员
     * @author lushusheng 2018-12-02
     * @param keyword 搜索关键字，模糊查询
     * @return 返回会员信息列表
     */
    List<User> selectListByConditionPage(@Param("type")Integer type, @Param("keyword") String keyword);

    /**
     * @desc 查询管理员列表，分页展示
     * @author lushusheng 2018-12-03
     * @return 返回管理员列表信息
     */
    List<User> getAdminListPage();
}