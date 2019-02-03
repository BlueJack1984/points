package com.tianbao.points.app.controller.migration;


import com.tianbao.points.app.controller.migration.input.RoleMigrationInput;
import com.tianbao.points.app.controller.migration.input.SystemBonusMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Role;
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

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc 数据迁移的系统积分入口
 * @author lushusheng
 * @date 2018-01-25
 */

@Api(value = "systemBonus", description = "系统积分")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/system/bonus")
@Slf4j
public class SystemBonusMigrationController {

    private final ISystemBonusService systemBonusService;
    private SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    /**
     * @desc 新建保存一条系统积分信息
     * @author lushusheng 2019-1-28
     * @param currentId 当前用户id
     * @param systemBonusMigrationInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条系统积分信息", notes = "新建保存一条系统积分信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "SystemBonusMigrationInput", name = "systemBonusMigrationInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputResult<SystemBonus> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid SystemBonusMigrationInput systemBonusMigrationInput)throws ApplicationException {
        SystemBonus systemBonus = new SystemBonus();
        copyProperties(systemBonus, systemBonusMigrationInput);
        systemBonus.setStatus(StatusCode.NORMAL.getCode());
        systemBonus.setCreateTime(new Date());
        systemBonus.setCreateUserId(currentId);
        systemBonus.setUpdateTime(new Date());
        systemBonus.setUpdateUserId(currentId);
        systemBonusService.save(systemBonus);
        return new OutputResult<>(systemBonus);
    }
    private void copyProperties(SystemBonus target, SystemBonusMigrationInput source)throws ApplicationException {
        if(target == null || source == null) {
            return;
        }
        try {
            Date original = sdf.parse(source.getCreateTime());
            String format = SDF.format(original);
            Date createTime = SDF.parse(format);
            target.setCreateTime(createTime);
        } catch (ParseException e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "创建时间格式错误");
        }
        target.setId(source.getId());
        target.setStartPoints(source.getStartPoints());
        target.setEndPoints(source.getEndPoints());
        target.setRatio(source.getRatio());
        target.setVisible(source.getVisible());
    }
}
