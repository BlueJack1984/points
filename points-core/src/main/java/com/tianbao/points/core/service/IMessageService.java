package com.tianbao.points.core.service;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.dto.UserMessageDTO;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 留言服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IMessageService extends IBaseService<Message, Long> {

    /**
     * @desc 根据留言id集合查询留言列表
     * @author lushusheng 2018-12-04
     * @param ids 输入的留言集合
     * @return 返回查询的留言实体数据列表
     * @throws ApplicationException 查询异常
     */
    List<Message> getListByIds(List<Long> ids) throws ApplicationException;

    /**
     * @desc 获取会员自己的留言列表,分页展示
     * @author lushusheng 2018-12-17
     * @param currentId 当前用户id
     * @param receiverId 接收者id，如果不传值，则搜索全部
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    PageInfo<UserMessageDTO> getListPage(Long currentId, Long receiverId, Integer pageNo, Integer pageSize)throws ApplicationException;


    /**
     * @desc 发送（保存）一条留言数据
     * @author lushusheng 2018-12-17
     * @param title 留言参数输入实体
     * @param content 留言参数输入实体
     * @param currentId 当前用户id
     * @param idList 留言参数输入实体
     * @return 保存成功实体数据
     * @throws ApplicationException 保存异常
     */
    Message save(String title, String content, Long currentId, List<Long> idList)throws ApplicationException;

    /**
     * @desc 根据id查询一条留言数据
     * @author lushusheng 2018-11-28
     * @param id 要查询的留言id
     * @param currentId 当前用户id
     * @param receiverId 接收者id
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    UserMessageDTO selectById(Long id, Long currentId, Long receiverId) throws ApplicationException;

}
