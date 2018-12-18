package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.UserMessage;
import com.tianbao.points.core.exception.ApplicationException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IUserMessageDao extends IBaseDao<UserMessage, Long> {
    /**
     * @desc 根据实体id和发送者id和接收者id查询出实体
     * @author lushusheng 2018-12-01
     * @param currentId 当前用户id
     * @param ids 留言实体id集合
     * @return 返回查询结果
     */
    List<UserMessage> selectListByIds(@Param("ids") List<Long> ids, @Param("currentId") Long currentId);
    /**
     * @desc 根据会员id模糊查询留言关联数据
     * @author lushusheng 2018-12-04
     * @param keyword 输入的会员id，查询关键词，模糊查询，分页展示
     * @param currentId 当前管理员用户id
     * @return 返回查询的留言实体关联数据
     */
    List<UserMessage> selectListByCondition(@Param("keyword") String keyword, @Param("type") Integer type,
                                            @Param("id") Long id, @Param("currentId") Long currentId);

    /**
     * @desc 历史数据, 查询某个会员的历史留言记录，分页查询，已处理的留言
     * @author lushusheng 2018-12-01
     * @param id 实体id
     * @param currentId 当前用户id
     * @return 返回查询的留言实体数据
     */
    UserMessage selectById(@Param("id") Long id, @Param("currentId") Long currentId);

    /**
     * @desc 批量更新实体
     * @author lushusheng 2018-12-01
     * @param userMessageList 实体集合
     * @return 返回无
     */
    void updateBatch(@Param("userMessageList") List<UserMessage> userMessageList);

    /**
     * @desc 批量插入用户留言关联表数据
     * @author lushusheng 2018-12-17
     * @param userMessageList 留言实体集合
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    void insertBatch(@Param("userMessageList") List<UserMessage> userMessageList);
}