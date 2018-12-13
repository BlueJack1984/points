package com.tianbao.points.admin.controller.security;

import com.tianbao.points.admin.dto.request.LoginInput;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class SecurityController {

    /**
     * @author lushusheng
     * @description 用户登录
     * @date 2018-12-11
     * @time 11:12
     */
    @PostMapping("/login")
    public void login(@RequestBody @Valid LoginInput loginInput) throws Exception {

        //判断验证码是否正确
        if (!StringUtils.isEmpty(loginInput.getCaptcha())) {
            log.info("-----------------------------------> 图形验证码正确");
        }
        /**
         * 使用shiro编写认证（登录）操作
         */
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户的登录数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginInput.getAccount(), loginInput.getPassword());
        //3.执行登录方法,这里会抛出多种类型异常
        subject.login(usernamePasswordToken);
        //返回得到的jwttoken给前端
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
    //@PostMapping("/doLogin")
//    public OutputResult doLogin(String username, String password) {
//
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
//            subject.login(token);
//        } catch (AuthenticationException e) {
//            token.clear();
//            //return ResultGenerator.genFailResult("登录失败，用户名或密码错误！");
//            return null;
//        }
//        //return ResultGenerator.genSuccessResult("登录成功");
//        return null;
//    }
}