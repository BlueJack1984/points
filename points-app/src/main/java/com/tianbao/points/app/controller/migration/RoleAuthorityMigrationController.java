package com.tianbao.points.app.controller.migration;

import com.tianbao.points.app.controller.migration.input.RoleAuthorityMigrationInput;
import com.tianbao.points.app.controller.migration.input.RoleMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.entity.RoleAuthority;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRoleAuthorityService;
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
 * @desc 数据迁移的角色权限关联实体入口
 * @author lushusheng
 * @date 2018-01-30
 */

@Api(value = "roleAuthority", description = "角色权限关联实体")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/role/authority")
@Slf4j
public class RoleAuthorityMigrationController {

    private final IRoleAuthorityService roleAuthorityService;

    /**
     * @desc 新建保存一条角色权限关联实体信息
     * @author lushusheng 2019-1-30
     * @param currentId 当前用户id
     * @param roleAuthorityMigrationInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条角色权限关联实体信息", notes = "新建保存一条角色权限关联实体信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "RoleAuthorityMigrationInput", name = "roleAuthorityMigrationInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputResult<RoleAuthority> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid RoleAuthorityMigrationInput roleAuthorityMigrationInput)throws ApplicationException {
        RoleAuthority roleAuthority = new RoleAuthority();
        copyProperties(roleAuthority, roleAuthorityMigrationInput);
        roleAuthority.setStatus(StatusCode.NORMAL.getCode());
        roleAuthority.setCreateTime(new Date());
        roleAuthority.setCreateUserId(currentId);
        roleAuthority.setUpdateTime(new Date());
        roleAuthority.setUpdateUserId(currentId);
        roleAuthorityService.save(roleAuthority);
        return new OutputResult<>(roleAuthority);
    }
    private void copyProperties(RoleAuthority target, RoleAuthorityMigrationInput source) {
        target.setId(source.getId());
        target.setRoleId(source.getRoleId());
        target.setAuthorityId(source.getAuthorityId());
    }
}
