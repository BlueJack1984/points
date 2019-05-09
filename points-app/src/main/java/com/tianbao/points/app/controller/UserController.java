package com.tianbao.points.app.controller;

import com.tianbao.points.app.dto.request.PersonalInfoInput;
import com.tianbao.points.app.dto.request.UserInput;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    @Value("${password.encrypt.key}")
    private String PASSWORD_SECRET_KEY;

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
        //获取所有合法用户列表,包含会员等级信息
        List<UserDTO> userDTOList = userServer.getList();
        if (userDTOList == null) {
            throw new ApplicationException(ApplicationException.MEMBER_USER_NOT_EXISTS, "已审核会员用户列表为空");
        }
        for(UserDTO userDTO: userDTOList) {
            if(userInput.getAccount().equals(userDTO.getAccount())) {
                throw new ApplicationException(ApplicationException.ACCOUNT_PARAM_ERROR, "该会员用户已存在，账号输入错误");
            }
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
        String encoded = null;
        try {
            encoded = MD5.EncoderByMd5(source.getPassword() + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.PASSWORD_ENCRYPT_ERROR, "用户登录密码加密错误");
        }
        target.setPassword(encoded);
        target.setPhone(source.getPhone());
        target.setProvince(source.getProvince());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        target.setCertificationTime(certificationTime);
    }

    /**
     * @author lushusheng
     * @Date 2019-5-9
     * @Desc 根据会员id更新会员的个人信息
     * @return 返回更新后的实体
     * @update
     */
    @ApiOperation(value = "根据会员id更新会员的个人信息", notes = "根据会员id更新会员的个人信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "PersonalInfoInput", name = "personalInfoInput", value = "更新内容", required = true)})
    @CrossOrigin
    @PostMapping("/update")
    @RequiresPermissions({"app:user:update"})
    @RequiresAuthentication
    public OutputResult<User> update(
            @RequestHeader(value = "_current_id") Long currentId,
            @RequestBody @Valid PersonalInfoInput personalInfoInput)throws ApplicationException {
        User user = userServer.selectById(currentId);
        if(user == null) {
            throw new ApplicationException(ApplicationException.MEMBER_USER_NOT_EXISTS, "会员用户实体不存在");
        }
        updateProperties(user, personalInfoInput);
        user.setUpdateTime(new Date());
        user.setUpdateUserId(currentId);
        userServer.updateById(user);
        return new OutputResult<>(user);
    }

    /**
     * @author lushusheng
     * @Date 2019-5-9
     * @Desc 复制更新的属性
     * @return 无返回
     * @update
     */
    private void  updateProperties(User target, PersonalInfoInput source) throws ApplicationException {

        if(target == null || source == null) {
            return;
        }
        target.setRealName(source.getRealName());
        target.setIdentityNumber(source.getIdentityNumber());
        if(source.getGender() != null) {
            target.setGender(source.getGender());
        }
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
}
