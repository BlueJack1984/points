package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Announcement;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 留言服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "message", description = "留言")
@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
@Slf4j
public class MessageController {
    /**
     * 注入留言服务service
     */
    private final IMessageService messageServer;

    /**
     * @desc 根据id查询一条留言数据
     * @author lushusheng 2018-12-01
     * @param id 要查询的留言id
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "查询留言数据", notes = "根据id查询一条留言数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "留言实体id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "senderId", value = "发送者id", required = true),
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)
    })
    @CrossOrigin
    @GetMapping("/get/{senderId}/{id}")
    public OutputResult<MessageDTO> get(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("senderId") Long senderId,
            @PathVariable("id") Long id)throws ApplicationException {

        MessageDTO messageDTO = messageServer.selectByIds(id, senderId, currentId);
        return new OutputResult<>(messageDTO);
    }

    /**
     * @desc 根据发送者id和接收者id查询所有留言数据列表, 需要分页
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 显示数据条数
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "根据发送者id和接收者id查询留言数据列表", notes = "根据发送者id和接收者id查询留言数据列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "senderId", value = "发送者id", required = true),
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "当前页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/{senderId}")
    public OutputListResult<MessageDTO> getListBySenderId(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20")Integer pageSize,
            @PathVariable("senderId") Long senderId)throws ApplicationException {

        PageInfo<MessageDTO> pageInfo = messageServer.getListBySenderId(senderId, currentId, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据实体id和发送者id和接收者id删除实体
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回删除操作结果
     * @throws ApplicationException 操作异常
     */
    @ApiOperation(value = "根据实体id和发送者id和接收者id删除实体", notes = "根据实体id和发送者id和接收者id删除实体")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "senderId", value = "发送者id", required = true),
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "留言实体id", required = true)})
    @CrossOrigin
    @GetMapping("/delete/{senderId}/{id}")
    public OutputResult<Void> delete(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id")Long id,
            @PathVariable("senderId") Long senderId)throws ApplicationException {

        messageServer.deleteByIds(id, senderId, currentId);
        return new OutputResult<>();
    }
}
