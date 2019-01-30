package com.tianbao.points.app.controller.migration;

import com.tianbao.points.app.controller.migration.input.PersonalBonusMigrationInput;
import com.tianbao.points.app.controller.migration.input.RankMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @desc 数据迁移的会员等级入口
 * @author lushusheng
 * @date 2019-01-28
 */

@Api(value = "rank", description = "会员等级")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/rank")
@Slf4j
public class RankMigrationController {

    private final IRankService rankService;

    /**
     * @desc 新建保存一条会员等级信息
     * @author lushusheng 2019-1-28
     * @param currentId 当前用户id
     * @param rankMigrationInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条会员等级信息", notes = "新建保存一条会员等级信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "RankMigrationInput", name = "rankMigrationInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputResult<Rank> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid RankMigrationInput rankMigrationInput)throws ApplicationException {
        Rank rank = new Rank();
        copyProperties(rank, rankMigrationInput);
        rank.setStatus(StatusCode.NORMAL.getCode());
        rank.setCreateTime(new Date());
        rank.setCreateUserId(currentId);
        rank.setUpdateTime(new Date());
        rank.setUpdateUserId(currentId);
        rankService.save(rank);
        return new OutputResult<>(rank);
    }
    private void copyProperties(Rank target, RankMigrationInput source) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setAlias(source.getAlias());
        target.setBasePoints(source.getBasePoints());
        target.setBaseMoney(source.getBaseMoney());
        target.setColor(source.getColor());
        target.setMaxBonus(source.getMaxBonus());
        target.setOrder(source.getOrder());
    }
}
