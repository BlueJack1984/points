package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.dto.response.SystemBonusOutput;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.ISystemBonusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @desc 系统积分增值服务入口
 * 财务管理，包括增值积分结算和增值积分列表
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
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 增值积分结算：计算当前系统的总积分并生成系统权重比率系数
     * @param currentId 表示当前管理员id
     * @return 返回系统积分输出属性实体SystemBonusOutput
     * @update
     */
    @ApiOperation(value = "计算当前系统的总积分并生成系统权重比率系数", notes = "计算当前系统的总积分并生成系统权重比率系数")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)})
    @CrossOrigin
    @GetMapping("/balance")
    //@RequiresPermissions({"admin:system:bonus:balance"})
    //@RequiresAuthentication
    public OutputResult<SystemBonusOutput> balance(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId)throws ApplicationException {

        SystemBonusOutput systemBonusOutput = systemBonusServer.balance();
        return new OutputResult<>(systemBonusOutput);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 结算当日系统总积分和个人总积分, 判断同一天不能多次结算，最多一次
     * 批量插入个人积分增值数据
     * @param currentId 表示当前管理员id
     * @param systemRatio 系统权重比率
     * @return 返回系统积分输出属性实体SystemBonusOutput
     * @update
     */
    @ApiOperation(value = "结算当日系统总积分和个人总积分", notes = "批量插入个人积分增值数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Double", name = "systemRatio", value = "系统权重比率", required = true)})
    @CrossOrigin
    @GetMapping("/checkout")
    //@RequiresPermissions({"admin:system:bonus:checkout"})
    //@RequiresAuthentication
    public OutputResult<Void> checkout(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam("systemRatio") Double systemRatio)throws ApplicationException {
        Date today = new Date();
        //数据库中查询最新的一条数据日期
        SystemBonus systemBonus = systemBonusServer.getLatest();
        if(systemBonus != null && DateUtils.isSameDay(today, systemBonus.getCreateTime())) {
            throw new ApplicationException(1,"同一天不能结算两次，今天已经结算过");
        }
        systemBonusServer.checkout(systemRatio, currentId);
        return new OutputResult<>();
    }

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
    //@RequiresPermissions({"admin:system:bonus:list"})
    //@RequiresAuthentication
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
    //@RequiresPermissions({"admin:system:bonus:visible"})
    //@RequiresAuthentication
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
     * @param currentId 表示当前管理员id
     * @return 返回操作结果，操作失败则抛出异常
     * @update
     */
    @ApiOperation(value = "根据id强行清空系统积分增值数据", notes = "根据id强行清空系统积分增值数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "系统积分增值id", required = true)})
    @CrossOrigin
    @GetMapping("/delete/{id}")
    //@RequiresPermissions({"admin:system:bonus:delete"})
    //@RequiresAuthentication
    public OutputResult<Void> delete(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {
        //逻辑删除
        systemBonusServer.deleteById(id, currentId);
        return new OutputResult<>();
    }
}
