package com.tianbao.points.app.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.app.dto.request.MessageInput;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IMessageService;
import com.tianbao.points.core.service.IUserMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
     * @desc 获取会员自己的留言列表,分页展示
     * @author lushusheng 2018-12-17
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "获取会员自己的留言列表,分页展示", notes = "获取会员自己的留言列表,分页展示")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page")
    public OutputListResult<MessageDTO> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) throws Exception {

        PageInfo<MessageDTO> pageInfo = messageServer.getListPage(currentId, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据id查询一条公告数据
     * @author lushusheng 2018-11-28
     * @param id 要查询的公告id
     * @param currentId 当前用户id
     * @return 返回查询的公告实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "查询首页公告数据", notes = "根据id查询一条公告数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "首页公告实体id", required = true),
            @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)
    })
    @CrossOrigin
    @GetMapping("/get/{id}")
    public OutputResult<MessageDTO> get(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable Long id)throws ApplicationException {

        //MessageDTO messageDTO = messageServer.selectById(id);
        return new OutputResult<>(null);
    }

    /**
     * @desc 发送（保存）一条留言数据
     * @author lushusheng 2018-12-17
     * @param messageInput 留言参数输入实体
     * @param currentId 当前用户id
     * @return 保存成功实体数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "发送（保存）一条留言数据", notes = "发送（保存）一条留言数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "MessageInput", name = "messageInput", value = "留言参数输入实体", required = true),
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)
    })
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<Message> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid MessageInput messageInput) throws ApplicationException {

        List<Long> idList = messageInput.getIdList();
        if(idList == null) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "接收者id集合参数错误");
        }
        Message message = messageServer.save(messageInput.getTitle(), messageInput.getContent(),
                currentId, idList);
        return new OutputResult<>(message);
    }
}
