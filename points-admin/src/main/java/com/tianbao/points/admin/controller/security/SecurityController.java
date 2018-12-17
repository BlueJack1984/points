package com.tianbao.points.admin.controller.security;

import com.tianbao.points.admin.dto.request.LoginInput;
import com.tianbao.points.admin.security.JwtToken;
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
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
        if (!StringUtils.isEmpty(loginInput.getCaptcha())) {
            log.info("-----------------------------------> 图形验证码正确");
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
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "用户账号参数错误");
        }
        String encoded = null;
        try {
            encoded = MD5.EncoderByMd5(password + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.INNER_ERROR, "用户登录密码加密错误");
        }
        if(! encoded.equals(user.getPassword())) {
            throw new ApplicationException(ApplicationException.PARAM_ERROR, "用户登录密码参数错误");
        }
        //返回得到的jwttoken给前端
        String token = JwtUtil.sign(account, user.getPassword());
        JwtToken jwtToken = new JwtToken(user.getId(), token);
        return new OutputResult<>(jwtToken);
    }

    /**
     * @author lushusheng
     * @description 用户退出登录
     * @date 2018-12-11
     * @time 12:12
     */
    @PostMapping("/logout")
    public void logout() {

    }
}