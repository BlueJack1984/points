package com.tianbao.points.app.controller.migration;

import com.tianbao.points.app.controller.migration.input.RankMigrationInput;
import com.tianbao.points.app.controller.migration.input.RoleMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @desc 数据迁移的角色入口
 * @author lushusheng
 * @date 2018-01-25
 */

@Api(value = "role", description = "角色")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/role")
@Slf4j
public class RoleMigrationController {

    private final IRoleService roleService;

    /**
     * @desc 新建保存一条角色信息
     * @author lushusheng 2019-1-28
     * @param currentId 当前用户id
     * @param roleMigrationInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条角色信息", notes = "新建保存一条角色信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "RoleMigrationInput", name = "roleMigrationInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputResult<Role> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid RoleMigrationInput roleMigrationInput)throws ApplicationException {
        Role role = new Role();
        copyProperties(role, roleMigrationInput);
        role.setStatus(StatusCode.NORMAL.getCode());
        role.setCreateTime(new Date());
        role.setCreateUserId(currentId);
        role.setUpdateTime(new Date());
        role.setUpdateUserId(currentId);
        roleService.save(role);
        return new OutputResult<>(role);
    }
    private void copyProperties(Role target, RoleMigrationInput source) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setDomain(source.getDomain());
        target.setType(source.getType());
    }
}
