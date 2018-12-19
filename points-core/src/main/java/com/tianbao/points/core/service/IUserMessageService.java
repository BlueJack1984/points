package com.tianbao.points.core.service;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.UserMessageDTO;
import com.tianbao.points.core.entity.UserMessage;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 用户留言关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IUserMessageService extends IBaseService<UserMessage, Long> {

    /**
     * @desc 根据一个id或者多个id列表删除实体
     * @author lushusheng 2018-12-04
     * @param ids 实体id列表
     * @param currentId 当前用户id
     * @return 返回操作结果
     * @throws ApplicationException 查询异常
     */
    void deleteByIds(List<Long> ids, Long currentId) throws ApplicationException;

    /**
     * @desc 根据会员id模糊查询留言关联数据
     * @author lushusheng 2018-12-04
     * @param keyword 输入的会员id，查询关键词，模糊查询，分页展示
     * @param id 精确查询此会员id
     * @param type 查询类型：0表示未处理和已处理均查询，1表示查询未处理，2表示查询已处理
     * @param currentId 当前管理员用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询的留言实体关联数据
     * @throws ApplicationException 查询异常
     */
    PageInfo<UserMessageDTO> getListByCondition(String keyword, Integer type, Long id, Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException;

    /**
     * @desc 根据id查询实体详情
     * @author lushusheng 2018-12-04
     * @param id 实体id
     * @param currentId 当前用户id
     * @return 返回查询到的结果
     * @throws ApplicationException 查询异常
     */
    UserMessageDTO getById(Long id, Long currentId)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 根据参数更新实体数据，不管数据是否为空都更新覆盖
     * @param id 实体id
     * @param currentId 当前用户id
     * @param reply 回复
     * @param status 状态
     * @return 返回无，出错抛出异常
     * @update
     */
    UserMessageDTO updateById(Long id, Long currentId, String reply, Integer status) throws ApplicationException;

    /**
     * @desc 批量插入用户留言关联表数据
     * @author lushusheng 2018-12-17
     * @param userMessageList 留言实体集合
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    void insertBatch(List<UserMessage> userMessageList) throws ApplicationException;

    /**
     * @desc 获取会员自己的留言列表
     * @author lushusheng 2018-12-17
     * @param currentId 当前用户id
     * @param receiverId 接收者id，如果不传值，则搜索全部
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    List<UserMessage> getListPage(Long currentId, Long receiverId)throws ApplicationException;
}
