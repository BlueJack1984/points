package com.tianbao.points.admin.controller.exception;

import com.tianbao.points.core.exception.ApplicationException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 截获spring boot Error页面
 * 主要捕捉jwt异常返回界面
 */
//@Controller
public class JwtFilterExceptionController implements ErrorController {

    /**
     * @desc 获取会员自己的留言列表,分页展示
     * @author lushusheng 2018-12-17
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
    /**
     * @desc 获取会员自己的留言列表,分页展示
     * @author lushusheng 2018-12-17
     * @param request 当前用户id
     * @param response 当前页码
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    @RequestMapping(value = "/error")
    public void error(HttpServletRequest request, HttpServletResponse response) throws ApplicationException {

        // 错误处理逻辑
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        if(exception == null) {
            throw new ApplicationException(ApplicationException.SC_NO_AUTHORITY, "没有权限访问该资源");
        }
        Throwable cause = exception.getCause();
        if(cause instanceof SignatureException) {
            /**
             * 在解析JWT字符串时，如果密钥不正确，将会解析失败
             * 抛出SignatureException异常，说明该JWT字符串是伪造的
             */
            //response.setStatus(HttpStatus.BAD_REQUEST.value());
            throw new ApplicationException(ApplicationException.JWT_SIGN, "签名错误，token秘钥不正确");
        }else if(cause instanceof ExpiredJwtException) {
            /**
             * 在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间
             * 将会抛出ExpiredJwtException异常，说明本次请求已经失效
             */
            //response.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
            throw new ApplicationException(ApplicationException.JWT_EXPIRE, "token令牌有效时间已过期");
        }else if(cause instanceof MalformedJwtException) {
            //response.setStatus(HttpStatus.FORBIDDEN.value());
            throw new ApplicationException(ApplicationException.JWT_FORMAT, "token令牌格式错误");
        }else {
            throw new ApplicationException(ApplicationException.JWT_BASE, cause.getMessage());
        }
    }
}
