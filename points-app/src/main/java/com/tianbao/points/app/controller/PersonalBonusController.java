package com.tianbao.points.app.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.PersonalBonusDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 个人积分增值服务入口
 * @author lushusheng
 * @date 2018-12-17
 */

@Api(value = "personalBonus", description = "个人积分增值")
@RestController
@RequiredArgsConstructor
@RequestMapping("/personal/bonus")
@Slf4j
public class PersonalBonusController {
    /**
     * 注入个人积分增值服务service
     */
    private final IPersonalBonusService personalBonusServer;

    /**
     * @author lushusheng
     * @Date 2018-12-17
     * @Desc 根据当前用户id查询个人积分增值列表,分页倒叙排列
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询到个人积分增值相关列表
     * @update
     */
    @ApiOperation(value = "根据当前用户id查询个人积分增值列表", notes = "根据当前用户id查询个人积分增值列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数")})
    @CrossOrigin
    @GetMapping("/list/page")
    public OutputListResult<PersonalBonus> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize)throws ApplicationException {

        PageInfo<PersonalBonus> pageInfo = personalBonusServer.getPersonalListByUserIdPage(pageNo, pageSize, currentId);
        return new OutputListResult<>(pageInfo);
    }
}
