package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.ReplyInput;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /**
     * @desc 根据实体id和发送者id和接收者id回复实体
     * @author lushusheng 2018-12-02
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回
     * @throws ApplicationException 操作异常
     */
    @ApiOperation(value = "根据实体id和发送者id和接收者id删除实体", notes = "根据实体id和发送者id和接收者id删除实体")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "senderId", value = "发送者id", required = true),
            @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "留言实体id", required = true)})
    @CrossOrigin
    @PostMapping("/reply/{senderId}/{id}")
    public OutputResult<MessageDTO> reply(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid ReplyInput reply,
            @PathVariable("id")Long id,
            @PathVariable("senderId") Long senderId)throws ApplicationException {

        messageServer.deleteByIds(id, senderId, currentId);
        return new OutputResult<>();
    }
}
