package com.tianbao.points.app.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.AnnouncementDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.entity.ConsumeRecord;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IConsumeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 消费记录入口
 * @author lushusheng
 * @date 2018-12-17
 */

@Api(value = "consumeRecord", description = "消费记录")
@RestController
@RequiredArgsConstructor
@RequestMapping("/consume/record")
@Slf4j
public class ConsumeRecordController {

    private final IConsumeRecordService consumeRecordServer;

    /**
     * @desc 获取消费记录列表,分页展示
     * @author lushusheng 2018-12-17
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "获取消费记录列表", notes = "获取消费记录列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page")
    @RequiresPermissions({"app:consume:record:list"})
    @RequiresAuthentication
    public OutputListResult<ConsumeRecord> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) throws Exception {

        PageInfo<ConsumeRecord> pageInfo = consumeRecordServer.getListPage(pageNo, pageSize, currentId);
        return new OutputListResult<>(pageInfo);
    }
}
