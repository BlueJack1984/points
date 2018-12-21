package com.tianbao.points.app.controller.security;

import com.tianbao.points.app.dto.request.LoginInput;
import com.tianbao.points.app.security.JwtToken;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.MD5;
import com.tianbao.points.core.utils.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lushusheng
 * @description 安全管理模块，包括用户登录和退出等
 * @date 2018-12-11
 * @time 11:12
 */
@RestController
@RequestMapping("/security")
@Slf4j
@RequiredArgsConstructor
public class SecurityController {

    private final IUserService userServer;
    @Value("${password.encrypt.key}")
    private String PASSWORD_SECRET_KEY;
    /**
     * @author lushusheng
     * @description 用户登录
     * @date 2018-12-11
     * @time 11:12
     */
    @PostMapping("/login")
    public OutputResult<JwtToken> login(@RequestBody @Valid LoginInput loginInput) throws ApplicationException {
        //判断验证码是否正确
        String userCaptcha = loginInput.getUserCaptcha();
        String sysCaptcha = loginInput.getSysCaptcha();
        if (! userCaptcha.equals(sysCaptcha)) {
            log.info("-----------------------------------> 图形验证码错误");
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "图形验证码校验错误");
        }
        /**
         * 使用shiro编写认证（登录）操作
         */
        String account = loginInput.getAccount();
        String password = loginInput.getPassword();
        //Subject subject = SecurityUtils.getSubject();
        //UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, password);
        //subject.login(usernamePasswordToken);

        //从数据库中查询用户
        User user = userServer.getByAccount(account);
        if(user == null) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "用户账号参数输入错误");
        }
        String encoded = null;
        try {
            encoded = MD5.EncoderByMd5(password + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.INNER_ERROR, "用户登录密码加密错误");
        }
        if(! encoded.equals(user.getPassword())) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "用户登录密码参数输入错误");
        }
        //返回得到的jwttoken给前端
        Subject subject = SecurityUtils.getSubject();
        String token = JwtUtil.sign(account, user.getPassword());
        JwtToken jwtToken = new JwtToken(user.getId(), token);
        try {
            //subject.login(jwtToken);
        } catch (UnknownAccountException ex) {
            throw new ApplicationException(ApplicationException.USER_NOT_EXISTS, "根据账号查询用户不存在");
        } catch (IncorrectCredentialsException ex) {
            throw new ApplicationException(ApplicationException.PASSWORD_ERROR, "登录密码校验错误");
        } catch (AuthenticationException ae) {
            throw new ApplicationException(ApplicationException.SC_NO_AUTHORITY, "用户认证失败，未知错误");
        }
        return new OutputResult<>(jwtToken);
    }

    /**
     * @author lushusheng
     * @description 查询用户是否认证登录
     * @date 2018-12-19
     * @time 12:12
     */
    @GetMapping("/article")
    public OutputResult<String> article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new OutputResult<>("You are already logged in");
        } else {
            return new OutputResult("You are guest");
        }
    }

    /**
     * @author lushusheng
     * @description 用户退出登录
     * @date 2018-12-11
     * @time 12:12
     */
    @GetMapping(value = "/logout")
    public OutputResult<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipals() != null) {
//            UserDto user = (UserDto)subject.getPrincipals().getPrimaryPrincipal();
//            userService.deleteLoginInfo(user.getUsername());
        }
        SecurityUtils.getSubject().logout();
        return new OutputResult<>("用户成功退出");
    }
}