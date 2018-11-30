package com.tianbao.points.admin.controller;

import com.tianbao.points.admin.dto.request.PasswordInput;
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
 * @desc 用户管理员入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "user", description = "用户管理员接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 注入用户服务service
     */
    private final IUserService userServer;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取用户的个人档案资料，包装了职位和角色信息
     * @return 返回查询到用户数据
     * @update
     */
    @ApiOperation(value = "查询用户管理员档案信息", notes = "根据当前用户currentId进行查询操作")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)})
    @CrossOrigin
    @GetMapping("/personal")
    public OutputResult<UserDTO> getPersonalInfo(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId)throws ApplicationException {
        UserDTO userDTO = userServer.getPersonalInfo(currentId);
        return new OutputResult<>(userDTO);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的登录密码，这里不是指超级密码
     * @param currentId 当前用户id
     * @param passwordInput 输入的密码属性实体
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @ApiOperation(value = "更新用户的登录密码", notes = "更新用户的登录密码")
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
     * @Desc 更新用户的超级密码，这个用户只有一个，顶级管理员，所以要先判断身份
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @ApiOperation(value = "更新用户的超级密码", notes = "更新用户的超级密码")
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
    //void updateSuperPassword(Long id)throws ApplicationException;


    /**
     * @desc 保存一条用户管理员数据
     * @author lushusheng 2018-11-29
     * @param announcementInput 首页公告实体属性：标题内容等
     * @param currentId 当前用户id
     * @return 是否保存成功
     * @throws ApplicationException 保存异常
     */
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<Void> save() {
        return null;
    }

}
