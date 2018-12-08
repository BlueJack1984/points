package com.tianbao.points.admin.controller.security;

//import com.tianbao.points.core.dto.response.OutputResult;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author zhaodong
// * @version v1.0
// * @email zhaodongxx@outlook.com
// * @since 2018/3/30 23:05
// */
//@RestController
//public class LoginController {
//    @PostMapping("/doLogin")
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
//}