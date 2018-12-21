package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.EntityIdsInput;
import com.tianbao.points.admin.dto.request.UserInput;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
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
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

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
     * @Desc 获取已审核的会员列表，分页展示
     * @return 返回查询到用户数据列表
     * @update
     */
    @ApiOperation(value = "获取已审核的会员列表", notes = "获取已审核的会员列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "当前页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page/audited")
    @RequiresPermissions({"admin:user:list:audited"})
    @RequiresAuthentication
    public OutputListResult<UserDTO> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "25")Integer pageSize)throws ApplicationException {
        PageInfo<UserDTO> pageInfo = userServer.getListPage(pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 通过会员id查询会员信息
     * @param currentId 当前用户id
     * @param id 输入的会员id
     * @return 返回会员实体信息
     * @update
     */
    @ApiOperation(value = "通过会员id查询会员信息", notes = "通过会员id查询会员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "memberId", value = "会员id", required = true)})
    @CrossOrigin
    @GetMapping("/get/{id}")
    @RequiresPermissions({"admin:user:query"})
    @RequiresAuthentication
    public OutputResult<UserDTO> get(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable Long id)throws ApplicationException {
        UserDTO userDTO = userServer.getById(id);
        return new OutputResult<>(userDTO);
    }

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 根据会员id更新会员的个人信息
     * @return 返回更新后的实体
     * @update
     */
    @ApiOperation(value = "根据会员id更新会员的个人信息", notes = "根据会员id更新会员的个人信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "UserInput", name = "userInput", value = "更新内容", required = true)})
    @CrossOrigin
    @PostMapping("/update")
    @RequiresPermissions({"admin:user:update"})
    @RequiresAuthentication
    public OutputResult<User> update(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid UserInput userInput)throws ApplicationException {
        User user = userServer.selectById(userInput.getId());
        if(user == null) {
            throw new ApplicationException(1, "查询的会员实体不存在");
        }
        copyProperties(user, userInput);
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        userServer.updateById(user);
        return new OutputResult<>(user);
    }
    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 复制更新的属性
     * @return 无返回
     * @update
     */
    private void  copyProperties(User target, UserInput source) throws ApplicationException {

        target.setRealName(source.getRealName());
        target.setRankId(source.getRankId());
        target.setIdentityNumber(source.getIdentityNumber());
        if(! StringUtils.isEmpty(source.getPhone())) {
            target.setPhone(source.getPhone());
        }
        if(! StringUtils.isEmpty(source.getProvince())) {
            target.setProvince(source.getProvince());
        }
        if(! StringUtils.isEmpty(source.getCity())) {
            target.setCity(source.getCity());
        }
        if(! StringUtils.isEmpty(source.getAddress())) {
            target.setAddress(source.getAddress());
        }
    }

    /**
     * @desc 根据会员id重置会员密码，设置为一个通用值
     * @author lushusheng 2018-12-02
     * @param id 会员id
     * @param currentId 当前用户id
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "根据会员id重置会员密码，设置为一个通用值", notes = "根据会员id重置会员密码，设置为一个通用值")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "会员id", required = true)})
    @CrossOrigin
    @GetMapping("/reset/password/{id}")
    @RequiresPermissions({"admin:user:reset:password"})
    @RequiresAuthentication
    public OutputResult<Void> reset(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable Long id)throws ApplicationException {
        userServer.resetPassword(id, currentId);
        return new OutputResult<>();
    }

    /**
     * @desc 按条件查询会员
     * @author lushusheng 2018-12-02
     * @param type 按照何种方式进行查询：0表示按照会员id
     * 1表示按照联系方式（手机号） 2表示按照真实姓名查询
     * @param keyword 搜索关键字
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回会员信息
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "按条件查询会员", notes = "按条件查询会员")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "type", value = "查询类型", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "String", name = "keyword", value = "查询关键词", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "当前页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page/condition")
    @RequiresPermissions({"admin:user:list:condition"})
    @RequiresAuthentication
    public OutputListResult<UserDTO> getListByConditionPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "25")Integer pageSize,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam("type") Integer type)throws ApplicationException {

        if(type == null || type.intValue() < 0 || type.intValue() > 2) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "会员搜索类型参数错误");
        }
        PageInfo<UserDTO> pageInfo = userServer.getListByConditionPage(type ,keyword, pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据会员id列表禁止会员登录，通过逻辑删除来实现
     * @author lushusheng 2018-12-12
     * @param idsInput 会员id输入列表
     * @param currentId 当前用户id
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "根据会员id列表禁止会员登录，通过逻辑删除来实现", notes = "根据会员id列表禁止会员登录，通过逻辑删除来实现")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "EntityIdsInput", name = "idsInput", value = "会员id列表", required = true)})
    @CrossOrigin
    @PostMapping("/forbid/login")
    @RequiresPermissions({"admin:user:forbid"})
    @RequiresAuthentication
    public OutputResult<Void> forbid(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid EntityIdsInput idsInput)throws ApplicationException {

        List<Long> idList = idsInput.getIdList();
        userServer.forbidBatch(idList, currentId);
        return new OutputResult<>();
    }
}
