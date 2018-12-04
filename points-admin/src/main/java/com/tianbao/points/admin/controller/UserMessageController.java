package com.tianbao.points.admin.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.dto.UserMessageDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 用户留言关联服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "userMessage", description = "用户留言关联")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/message")
@Slf4j
public class UserMessageController {
    /**
     * 注入用户留言关联服务service
     */
    private final IUserMessageService userMessageServer;

    /**
     * @desc 根据会员id模糊查询留言数据
     * @author lushusheng 2018-12-04
     * @param keyword 输入的会员id，查询关键词，模糊查询，分页展示
     * @param currentId 当前管理员用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "查询留言数据", notes = "模糊查询留言数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "keyword", value = "查询关键词", required = true),
            @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数")})
    @CrossOrigin
    @GetMapping("/get")
    public OutputListResult<UserMessageDTO> getByCondition(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam("keyword") String keyword)throws ApplicationException {

        if(StringUtils.isEmpty(keyword)) {
            throw new ApplicationException(1, "");
        }
        PageInfo<UserMessageDTO> pageInfo = userMessageServer.getByCondition(keyword,currentId, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 历史数据, 查询某个会员的历史留言记录，分页查询，已处理的留言
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 显示数据条数
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "查询某个会员的历史留言记录", notes = "查询某个会员的历史留言记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "senderId", value = "发送者id", required = true),
            @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "当前页码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page/{senderId}/solved")
    public OutputListResult<UserMessageDTO> getListBySenderId(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20")Integer pageSize,
            @PathVariable("senderId") Long senderId)throws ApplicationException {

        PageInfo<UserMessageDTO> pageInfo = userMessageServer.getListBySenderId(senderId, currentId, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }
}
