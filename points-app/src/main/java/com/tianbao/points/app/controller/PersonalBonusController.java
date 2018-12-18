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

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 个人积分列表中查询特定会员积分数据,模糊查询，分页展示
     * @param keyword 会员编号输入关键词
     * @param sysBonusId 表示系统积分增值id
     * @param currentId 表示当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回操查询到的数据
     * @update
     */
    @ApiOperation(value = "设置个人积分增值数据在客户端是否可见", notes = "设置个人积分增值数据在客户端是否可见")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "sysBonusId", value = "系统积分增值id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "String", name = "keyword", value = "会员编号输入关键词", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码"),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数")})
    @CrossOrigin
    @GetMapping("/list/page/condition/{sysBonusId}")
    public OutputListResult<PersonalBonusDTO> getByCondition(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam("keyword") String keyword,
            @PathVariable("sysBonusId") Long sysBonusId)throws ApplicationException {

        if(StringUtils.isEmpty(keyword)) {
            throw new ApplicationException(1, "输入关键词不能为空");
        }
        PageInfo<PersonalBonusDTO> pageInfo = personalBonusServer.getByCondition(keyword, sysBonusId, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

}
