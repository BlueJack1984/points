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
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions({"app:user:personal:info"})
    @RequiresAuthentication
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
    @RequiresPermissions({"app:user:personal:password"})
    @RequiresAuthentication
    public OutputResult<Void> updatePassword(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid PasswordInput passwordInput)throws ApplicationException {
        userServer.updatePassword(currentId, passwordInput.getOldPassword(),
                passwordInput.getNewPassword(), passwordInput.getSureNewPassword());
        return new OutputResult<>();
    }
}
