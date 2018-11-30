package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.PersonalBonusDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.ISystemBonusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 系统积分增值服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "systemBonus", description = "系统积分增值")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/bonus")
@Slf4j
public class SystemBonusController {
    /**
     * 注入系统积分增值服务service
     */
    private final ISystemBonusService systemBonusServer;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 查询系统积分增值列表，分页倒叙查询
     * @param pageNo 表示当前页面
     * @param pageSize 表示页面显示数据条数
     * @return 返回查询到系统积分增值相关列表
     * @update
     */
    @ApiOperation(value = "查询系统积分增值列表，分页倒叙查询", notes = "查询系统积分增值列表，分页倒叙查询")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数")})
    @CrossOrigin
    @GetMapping("/list/page")
    public OutputListResult<SystemBonus> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize)throws ApplicationException {

        PageInfo<SystemBonus> pageInfo = systemBonusServer.getListPage(pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 设置系统积分增值数据在客户端是否可见
     * @param id 表示系统积分增值id
     * @param currentId 表示当前用户id
     * @return 返回操作结果，操作失败则抛出异常
     * @update
     */
    @ApiOperation(value = "设置系统积分增值数据在客户端是否可见", notes = "设置系统积分增值数据在客户端是否可见")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "系统积分增值id", required = true)})
    @CrossOrigin
    @GetMapping("/visible/{id}")
    public OutputResult<Void> setVisibility(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {

        systemBonusServer.setVisibility(id, currentId);
        return new OutputResult<>();
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 根据id强行清空系统积分增值数据
     * @param id 表示系统积分增值id
     * @param currentId 表示当前用户id
     * @return 返回操作结果，操作失败则抛出异常
     * @update
     */
    @ApiOperation(value = "根据id强行清空系统积分增值数据", notes = "根据id强行清空系统积分增值数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "系统积分增值id", required = true)})
    @CrossOrigin
    @GetMapping("/delete/{id}")
    public OutputResult<Void> delete(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {
        //逻辑删除
        systemBonusServer.deleteById(id);
        return new OutputResult<>();
    }
}
