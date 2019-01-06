package com.tianbao.points.admin.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.RoleInput;
import com.tianbao.points.admin.dto.request.RoleUpdateInput;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRoleService;
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

/**
 * @desc 角色服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "role", description = "角色")
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Slf4j
public class RoleController {
    /**
     * 注入角色服务service
     */
    private final IRoleService roleServer;

    /**
     * @desc 获取角色列表，分页展示
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 数据条数
     * @return 返回数据列表
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "获取角色列表，分页展示", notes = "获取角色列表，分页展示")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "当前页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page")
    @RequiresPermissions({"admin:role:list"})
    @RequiresAuthentication
    public OutputListResult<Role> getListPage(
            @RequestHeader(value = "_current_id") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "25") Integer pageSize)throws ApplicationException {
        PageInfo<Role> pageInfo = roleServer.getListPage(pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据id获取角色信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 角色实体id
     * @return 返回角色信息
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "根据id获取角色信息", notes = "根据id获取角色信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "角色实体id", required = true)})
    @CrossOrigin
    @GetMapping("/get/{id}")
    @RequiresPermissions({"admin:role:query"})
    @RequiresAuthentication
    public OutputResult<Role> get(
            @RequestHeader(value = "_current_id") Long currentId,
            @PathVariable Long id)throws ApplicationException {
        Role role = roleServer.selectById(id);
        return new OutputResult<>(role);
    }

    /**
     * @desc 根据id更新实体信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param roleUpdateInput 需要更新的数据实体
     * @return 返回更新后的数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "根据id更新实体信息", notes = "根据id更新实体信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "RoleUpdateInput", name = "roleUpdateInput", value = "需要更新的数据实体", required = true)})
    @CrossOrigin
    @PostMapping("/update")
    @RequiresPermissions({"admin:role:update"})
    @RequiresAuthentication
    public OutputResult<Role> update(
            @RequestHeader(value = "_current_id") Long currentId,
            @RequestBody @Valid RoleUpdateInput roleUpdateInput)throws ApplicationException {
        Role role = roleServer.selectById(roleUpdateInput.getId());
        if(role == null) {
            throw new ApplicationException(1, "");
        }
        role.setName(roleUpdateInput.getName());
        if(! StringUtils.isEmpty(roleUpdateInput.getDescription())) {
            role.setDescription(roleUpdateInput.getDescription());
        }
        role.setUpdateTime(new Date());
        role.setUpdateUserId(currentId);
        roleServer.updateById(role);
        return new OutputResult<>(role);
    }
    /**
     * @desc 根据id删除实体
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 实体id
     * @return 返回操作结果
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "根据id删除实体", notes = "根据id删除实体")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "实体id", required = true)})
    @CrossOrigin
    @GetMapping("/delete/{id}")
    @RequiresPermissions({"admin:role:delete"})
    @RequiresAuthentication
    public OutputResult<Void> delete(
            @RequestHeader(value = "_current_id") Long currentId,
            @PathVariable Long id)throws ApplicationException {
        roleServer.delete(id, currentId);
        return new OutputResult<>();
    }

    /**
     * @desc 保存实体信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param roleInput 需要保存的数据实体
     * @return 返回保存后的数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "保存实体信息", notes = "保存实体信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "RoleInput", name = "roleInput", value = "需要保存的数据实体", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    @RequiresPermissions({"admin:role:save"})
    @RequiresAuthentication
    public OutputResult<Role> save(
            @RequestHeader(value = "_current_id") Long currentId,
            @RequestBody @Valid RoleInput roleInput)throws ApplicationException {

        Role role = roleServer.insert(roleInput.getName(), roleInput.getDescription(), currentId);
        return new OutputResult<>(role);
    }
}
