package com.tianbao.points.app.controller.migration;

import com.tianbao.points.app.controller.migration.input.PersonalBonusMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dto.response.OutputError;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import com.tianbao.points.core.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc 数据迁移的个人积分入口
 * @author lushusheng
 * @date 2019-01-28
 */

@Api(value = "personalBonus", description = "个人积分")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/personal/bonus")
@Slf4j
public class PersonalBonusMigrationController {

    private final IPersonalBonusService personalBonusService;
    SimpleDateFormat SDF = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    //@Autowired
    //@Lazy
    private final IUserService userService;
    /**
     * @desc 新建保存一条个人积分信息
     * @author lushusheng 2019-1-28
     * @param currentId 当前用户id
     * @param personalBonusMigrationInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条个人积分信息", notes = "新建保存一条个人积分信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "PersonalBonusMigrationInput", name = "personalBonusMigrationInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputError save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid PersonalBonusMigrationInput personalBonusMigrationInput)throws ApplicationException {

        User user = userService.getByAccount(personalBonusMigrationInput.getAccount());
        if(user == null) {
            throw new ApplicationException(ApplicationException.MEMBER_USER_NOT_EXISTS, "会员用户不存在");
        }
        PersonalBonus personalBonus = new PersonalBonus();
        PersonalBonus latest = personalBonusService.getLatestByUserId(user.getId());
        if(latest == null) {
            //第一次存入
            personalBonus.setParentId(0L);
        }else {
            personalBonus.setParentId(latest.getId());
        }
        personalBonus.setUserId(user.getId());
        copyProperties(personalBonus, personalBonusMigrationInput);
        personalBonus.setStatus(StatusCode.NORMAL.getCode());
        personalBonus.setCreateUserId(currentId);
        personalBonus.setUpdateTime(new Date());
        personalBonus.setUpdateUserId(currentId);
        personalBonusService.save(personalBonus);
        return new OutputError(200, "SUCCESS");
    }
    private void copyProperties(PersonalBonus target, PersonalBonusMigrationInput source)throws ApplicationException {
        try {
            Date createTime = SDF.parse(source.getCreateTime());
            target.setCreateTime(createTime);
        } catch (ParseException e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "创建时间格式错误");
        }
        target.setId(source.getId());
        target.setSystemBonusId(source.getSystemBonusId());
        target.setStartPoints(source.getStartPoints());
        target.setEndPoints(source.getEndPoints());
        target.setRatio(source.getRatio());
        target.setVisible(source.getVisible());
    }
}
