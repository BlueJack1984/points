package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.RankInput;
import com.tianbao.points.admin.dto.request.RankUpdateInput;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @desc 会员等级服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "rank", description = "会员等级")
@RestController
@RequiredArgsConstructor
@RequestMapping("/rank")
@Slf4j
public class RankController {
    /**
     * 注入会员等级服务service
     */
    private final IRankService rankServer;

    /**
     * @desc 查询会员等级列表，分页展示
     * @author lushusheng 2018-12-02
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询到的会员等级列表
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "查询会员等级列表，分页展示", notes = "查询会员等级列表，分页展示")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "当前页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page")
    public OutputListResult<Rank> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize)throws ApplicationException {
        PageInfo<Rank> pageInfo = rankServer.getListPage(pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据id查询会员等级数据
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 要查询的实体id
     * @return 返回查询结果
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "根据id查询会员等级数据", notes = "根据id查询会员等级数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "实体id", required = true)})
    @CrossOrigin
    @GetMapping("/get/{id}")
    public OutputResult<Rank> get(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable Long id)throws ApplicationException {
        Rank rank = rankServer.selectById(id);
        return new OutputResult<>(rank);
    }
    /**
     * @desc 根据id更新会员等级数据
     * @author lushusheng 2018-12-02
     * @param currentId 当前管理员用户id
     * @param rankUpdateInput 要更新的实体参数
     * @return 返回更新数据
     * @throws ApplicationException 更新异常
     */
    @ApiOperation(value = "根据id更新会员等级数据", notes = "根据id更新会员等级数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "RankUpdateInput", name = "rankUpdateInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/update")
    public OutputResult<Rank> update(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid RankUpdateInput rankUpdateInput)throws ApplicationException {

        Rank rank = rankServer.selectById(rankUpdateInput.getId());
        if(rank == null) {
            throw new ApplicationException(1, "");
        }
        copyProperties(rank, rankUpdateInput);
        rank.setUpdateTime(new Date());
        rank.setCreateUserId(currentId);
        rankServer.updateById(rank);
        return new OutputResult<>(rank);
    }
    /**
     * @desc 拷贝输入的属性到实体中
     * @author lushusheng 2018-12-05
     * @param target 目标实体
     * @param rankInput 要更新的实体参数
     * @return 返回更新数据
     * @throws ApplicationException 更新异常
     */
    private void copyProperties(Rank target, RankInput rankInput) {
        target.setName(rankInput.getName());
        target.setBaseMoney(rankInput.getBaseMoney());
        target.setBasePoints(rankInput.getBasePoints());
        target.setMaxBonus(rankInput.getMaxBonus());
        target.setOrder(rankInput.getOrder());
        if(! StringUtils.isEmpty(rankInput.getAlias())) {
            target.setAlias(rankInput.getAlias());
        }
        if(! StringUtils.isEmpty(rankInput.getColor())) {
            target.setAlias(rankInput.getColor());
        }
    }
    /**
     * @desc 新建保存会员等级数据
     * @author lushusheng 2018-12-05
     * @param currentId 当前管理员用户id
     * @param rankInput 要保存的实体参数
     * @return 返回更新数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "根据id更新会员等级数据", notes = "根据id更新会员等级数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "RankInput", name = "rankInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<Rank> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid RankInput rankInput)throws ApplicationException {
        Rank rank = new Rank();
        copyProperties(rank, rankInput);
        Rank saved = rankServer.insert(rank, currentId);
        return new OutputResult<>(saved);
    }
}
