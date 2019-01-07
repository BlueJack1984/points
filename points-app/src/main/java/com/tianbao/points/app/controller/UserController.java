package com.tianbao.points.app.controller;

import com.tianbao.points.app.dto.request.UserInput;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc 用户管理员入口
 * @author lushusheng
 * @date 2018-12-17
 */

@Api(value = "user", description = "会员功能接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 注入用户服务service
     */
    private final IUserService userServer;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @desc 新建保存一条会员用户信息
     * @author lushusheng 2018-12-17
     * @param currentId 当前用户id
     * @param userInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条会员用户信息", notes = "新建保存一条会员用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "UserInput", name = "userInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    @RequiresPermissions({"app:user:save"})
    @RequiresAuthentication
    public OutputResult<UserDTO> save(
            @RequestHeader(value = "_current_id") Long currentId,
            @RequestBody @Valid UserInput userInput)throws ApplicationException {

        if(! userInput.getPassword().equals(userInput.getSurePassword())) {
            throw new ApplicationException(ApplicationException.PASSWORD_NEW_SURE_NOT_EQUAL, "设置登录密码与确认密码不一致");
        }
        User user = new User();
        copyProperties(user, userInput);
        UserDTO userDTO = userServer.save(user, currentId);
        return new OutputResult<>(userDTO);
    }

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 复制更新的属性
     * @return 无返回
     * @update
     */
    private void  copyProperties(User target, UserInput source) throws ApplicationException {

        Date certificationTime = null;
        try {
            certificationTime = SDF.parse(source.getCertificationTime());
        } catch (ParseException e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "发证日期参数格式错误");
        }
        target.setAccount(source.getAccount());
        target.setRealName(source.getRealName());
        target.setGender(source.getGender());
        target.setRankId(source.getRankId());
        target.setIdentityNumber(source.getIdentityNumber());
        target.setPassword(source.getPassword());
        target.setPhone(source.getPhone());
        target.setProvince(source.getProvince());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        target.setCertificationTime(certificationTime);
    }
}
