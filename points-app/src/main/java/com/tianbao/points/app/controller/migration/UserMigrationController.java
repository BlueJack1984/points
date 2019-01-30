package com.tianbao.points.app.controller.migration;

import com.tianbao.points.app.controller.migration.input.SystemBonusMigrationInput;
import com.tianbao.points.app.controller.migration.input.UserMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc 数据迁移的会员用户入口
 * @author lushusheng
 * @date 2018-01-25
 */

@Api(value = "user", description = "会员")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/user")
@Slf4j
public class UserMigrationController {

    private final IUserService userService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    /**
     * @desc 新建保存一条会员信息
     * @author lushusheng 2019-1-28
     * @param currentId 当前用户id
     * @param userMigrationInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条会员信息", notes = "新建保存一条会员信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "UserMigrationInput", name = "userMigrationInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputResult<User> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid UserMigrationInput userMigrationInput)throws ApplicationException {
        User user = new User();
        copyProperties(user, userMigrationInput);
        user.setStatus(StatusCode.NORMAL.getCode());
        user.setCreateTime(new Date());
        user.setCreateUserId(currentId);
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        userService.save(user);
        return new OutputResult<>(user);
    }
    private void copyProperties(User target, UserMigrationInput source)throws ApplicationException {
        if(! StringUtils.isEmpty(source.getLastLoginTime())) {
            try {
                Date lastLoginTime = sdf.parse(source.getLastLoginTime());
                target.setLastLoginTime(lastLoginTime);
            } catch (ParseException e) {
                log.info(e.getMessage());
                throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "上次登录时间格式错误");
            }
        }

        if(! StringUtils.isEmpty(source.getCurrentLoginTime())) {
            try {
                Date currentLoginTime = sdf.parse(source.getCurrentLoginTime());
                target.setCurrentLoginTime(currentLoginTime);
            } catch (ParseException e) {
                log.info(e.getMessage());
                throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "本次登录时间格式错误");
            }
        }
        if(! StringUtils.isEmpty(source.getCertificationTime())) {
            try {
                Date certificationTime = sdf.parse(source.getCertificationTime());
                target.setCertificationTime(certificationTime);
            } catch (ParseException e) {
                log.info(e.getMessage());
                throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "发证时间格式错误");
            }
        }
        target.setId(source.getId());
        target.setAccount(source.getAccount());
        target.setPassword(source.getPassword());
        target.setRealName(source.getRealName());
        target.setIdentityNumber(source.getIdentityNumber());
        target.setNickName(source.getNickName());
        target.setHeadImage(source.getHeadImage());
        target.setPhone(source.getPhone());
        target.setEmail(source.getEmail());
        target.setGender(source.getGender());
        target.setRankId(source.getRankId());
        target.setQuestionId(source.getQuestionId());
        target.setAnswer(source.getAnswer());
        target.setLastLoginIp(source.getLastLoginIp());
        target.setCurrentLoginIp(source.getCurrentLoginIp());
        target.setProvince(source.getProvince());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
    }
}
