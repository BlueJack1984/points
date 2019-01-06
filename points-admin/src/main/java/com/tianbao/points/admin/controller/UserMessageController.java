package com.tianbao.points.admin.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.EntityIdsInput;
import com.tianbao.points.admin.dto.request.ReplyInput;
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
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @desc 用户留言关联服务入口
 * 一个留言id只能对应一个发送者
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
     * @desc 统一查询接口：
     * 1.查询未处理的特定id留言列表（模糊查询） 2.查询已处理的特定id留言列表（模糊查询）
     * 3.未处理的所有留言列表 4 已处理的所有留言列表 5.查询已处理的某个特定id的所有列表（精确查询）
     * @author lushusheng 2018-12-04
     * @param keyword 输入的会员id，查询关键词，模糊查询，分页展示
     * @param id 精确查询此会员id
     * @param type 查询类型：0表示未处理和已处理均查询，1表示查询未处理，2表示查询已处理
     * @param currentId 当前管理员用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "统一查询接口", notes = "统一查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "keyword", value = "查询关键词", required = false),
            @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "实体id",required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "type", value = "查询类型", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page/condition")
    @RequiresPermissions({"admin:message:list"})
    @RequiresAuthentication
    public OutputListResult<UserMessageDTO> getListByCondition(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "type", required = false, defaultValue = "0") Integer type,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword)throws ApplicationException {

        PageInfo<UserMessageDTO> pageInfo = userMessageServer.getListByCondition(keyword, type, id, currentId, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据一个id或者多个id列表删除实体
     * @author lushusheng 2018-12-04
     * @param idsInput 实体id列表
     * @param currentId 当前用户id
     * @return 返回操作结果
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "根据一个id或者多个id列表删除实体", notes = "根据一个id或者多个id列表删除实体")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "EntityIdsInput", name = "idsInput", value = "删除的id列表", required = true)})
    @CrossOrigin
    @PostMapping("/delete")
    //@RequiresPermissions({"admin:message:delete"})
    //@RequiresAuthentication
    public OutputResult<Void> deleteByIds(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody EntityIdsInput idsInput)throws ApplicationException {
        List<Long> idList = idsInput.getIdList();
        if(idList == null || idList.size() <= 0) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "实体id集合字符串不能为空");
        }
        userMessageServer.deleteByIds(idList, currentId);
        return new OutputResult<>();
    }


    /**
     * @desc 根据id查询实体详情
     * @author lushusheng 2018-12-04
     * @param id 实体id
     * @param currentId 当前用户id
     * @return 返回查询到的结果
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "根据id查询实体详情", notes = "根据id查询实体详情")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "实体id", required = true)})
    @CrossOrigin
    @GetMapping("/get/{id}")
    @RequiresPermissions({"admin:message:query"})
    @RequiresAuthentication
    public OutputResult<UserMessageDTO> getById(
            @RequestHeader(value = "_current_id") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {
        if(id == null) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "查询留言实体id不能为空");
        }
        UserMessageDTO userMessageDTO = userMessageServer.getById(id, currentId);
        return new OutputResult<>(userMessageDTO);
    }

    /**
     * @desc 管理员回复，更新实体内容
     * @author lushusheng 2018-12-04
     * @param currentId 当前用户id
     * @param replyInput 回复实体
     * @return 返回实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "管理员回复，更新实体内容", notes = "管理员回复，更新实体内容")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "ReplyInput", name = "replyInput", value = "回复实体", required = true)})
    @CrossOrigin
    @PostMapping("/reply")
    @RequiresPermissions({"admin:message:reply"})
    @RequiresAuthentication
    public OutputResult<UserMessageDTO> reply(
            @RequestHeader(value = "_current_id") Long currentId,
            @RequestBody @Valid ReplyInput replyInput)throws ApplicationException {

        UserMessageDTO userMessageDTO = userMessageServer.updateById(replyInput.getId(), currentId,
                replyInput.getReply(), replyInput.getStatus());
        return new OutputResult<>(userMessageDTO);
    }
}
