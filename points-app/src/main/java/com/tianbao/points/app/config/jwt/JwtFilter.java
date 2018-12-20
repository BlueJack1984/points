package com.tianbao.points.app.config.jwt;

import com.tianbao.points.app.security.JwtToken;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.exception.shiro.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 程序逻辑:
 * 我们POST用户名与密码到/login进行登入，如果成功返回一个加密token，失败的话直接返回401错误。
 * 之后用户访问每一个需要权限的网址请求必须在header中添加Authorization字段，例如Authorization: token，token为密钥。
 * 后台会进行token的校验，如果不通过直接返回401。
 * @author lushusheng
 * @create 2018-07-12 15:56
 * @desc 前面认证原理说到我们要使用shiro来拦截token，那就需要我们自己写一个jwt过滤器来作为shiro的过滤器
 **/
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 判断用户是否想要登录
     * 检测header里面是否包含Authorization字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        return authorization != null;
    }
    /**
     * 执行登录认证
     * @author lushusheng
     * @desc
     * 这里我们详细说明下为什么最终返回的都是true，即允许访问
     * 例如我们提供一个地址 GET /article
     * 登入用户和游客看到的内容是不同的
     * 如果在这里返回了false，请求会被直接拦截，用户看不到任何东西
     * 所以我们在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
     * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
     * 但是这样做有一个缺点，就是不能够对GET,POST等请求进行分别过滤鉴权(因为我们重写了官方的方法)，但实际上对应用影响不大
     * @param request http请求
     * @param response http响应
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){

        log.info("***********************这里经过了过滤器*************************");
        /**
         * 判断用户是否是登录还是已经登录的正常访问，通过判断是否携带Authorization实现
         * 请求是否已经登录（携带token）
         */
        if(isLoginAttempt(request, response)) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
                //return false;
                response401(request, response);
            }
        }
        /**
         * 如果请求头不存在Token，则可能是执行登陆操作或者是游客状态访问
         * 无需检查token，直接返回true
         */
        return true;
    }

    /**
     * 將請求返回到 /401
     */
    private void response401(ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        try {
            httpServletResponse.sendRedirect("/401");
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
    /**
     * 从请求头获取token并验证，验证通过后交给realm进行登录
     * 这个是在isAccessAllowed方法返回false执行
     * @param servletRequest
     * @param servletResponse
     * @return 返回结果为true表明登录通过
     * @throws Exception
     */
//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        log.info("***********************on access denied method*************************");
//        return true;
//    }

    /**
     *处理JWT异常
     * 这是个坑，因为是在filter内发生的异常，@ExceptionHandler是截获不到的。
     * filter层的异常不受exceptionAdvice控制,这里返回401,把返回的json丢到response中
     * Shiro中鑑權失敗時不能夠直接返回401信息，而是通過跳轉到 /401 地址實現。
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");
        Long id = Long.parseLong(httpServletRequest.getHeader("_current_id"));
        JwtToken jwtToken = new JwtToken(id, token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

//    @Override
//    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest request,
//                                     ServletResponse response) {
//        HttpServletResponse servletResponse = (HttpServletResponse) response;
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code", HttpServletResponse.SC_UNAUTHORIZED);
//        jsonObject.put("msg","登录失败，无权访问");
//        jsonObject.put("timestamp", System.currentTimeMillis());
//        try {
//            servletResponse.setCharacterEncoding("UTF-8");
//            servletResponse.setContentType("application/json;charset=UTF-8");
//            servletResponse.setHeader("Access-Control-Allow-Origin","*");
//            ObjectMapper objectMapper = new ObjectMapper();
//            response.getWriter().write(objectMapper.writeValueAsString(jsonObject));
//        } catch (IOException e) {
//        }
//        return false;
//    }
}