package com.tianbao.points.app.controller;

import com.tianbao.points.app.dto.request.PasswordInput;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @desc 会员个人中心入口
 * @author lushusheng
 * @date 2018-12-17
 */

@Api(value = "user", description = "会员个人中心接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/personal")
@Slf4j
public class PersonalController {

    /**
     * 注入用户服务service
     */
    private final IUserService userServer;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取会员的个人档案资料，包装了职位和角色及会员等级
     * @return 返回查询到会员数据
     * @update
     */
    @ApiOperation(value = "获取会员的个人档案资料", notes = "获取会员的个人档案资料")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)})
    @CrossOrigin
    @GetMapping("/info")
    public OutputResult<UserDTO> getPersonalInfo(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId)throws ApplicationException {
        UserDTO userDTO = userServer.getPersonalInfo(currentId);
        return new OutputResult<>(userDTO);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 修改密码，更新会员用户的登录密码，这里不是指超级密码
     * @param currentId 当前用户id
     * @param passwordInput 输入的密码属性实体
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @ApiOperation(value = "更新会员用户的登录密码", notes = "更新会员用户的登录密码")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)})
    @CrossOrigin
    @PostMapping("/password")
    public OutputResult<Void> updatePassword(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid PasswordInput passwordInput)throws ApplicationException {
        userServer.updatePassword(currentId, passwordInput.getOldPassword(),
                passwordInput.getNewPassword(), passwordInput.getSureNewPassword());
        return new OutputResult<>();
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新管理员的超级密码，只有一个，顶级管理员，所以要先判断身份
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @ApiOperation(value = "更新顶级管理员的超级密码", notes = "更新顶级管理员的超级密码")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)})
    @CrossOrigin
    @PostMapping("/super/password")
    public OutputResult<Void> updateSuperPassword(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid PasswordInput passwordInput)throws ApplicationException {
        userServer.updateSuperPassword(currentId, passwordInput.getOldPassword(),
                passwordInput.getNewPassword(), passwordInput.getSureNewPassword());
        return new OutputResult<>();
    }


    /**
     * @desc 保存一条用户管理员数据
     * @author lushusheng 2018-11-29
     * @return 是否保存成功
     * @throws ApplicationException 保存异常
     */
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<Void> save() {
        return new OutputResult<>();
    }
}
