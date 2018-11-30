package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.PersonalBonusDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
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
    public OutputListResult<PersonalBonusDTO> getListBySysBonusIdPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @PathVariable("sysBonusId") Long sysBonusId)throws ApplicationException {

        PageInfo<PersonalBonusDTO> pageInfo = personalBonusServer.getListBySysBonusIdPage(sysBonusId, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }
}
