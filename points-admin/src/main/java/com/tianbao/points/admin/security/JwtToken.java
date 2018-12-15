package com.tianbao.points.admin.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created with IntelliJ IDEA
 *
 * @author lushusheng
 * @Description jwt token
 * @Date 2018-12-12
 * @Time 16:54
 */
public class JwtToken implements AuthenticationToken {

    /**
     * 令牌id
     */
    private long id;
    /**
     * 令牌数据
     */
    private String token;
    /**
     * 令牌有效期，毫秒
     */
    //private long expire;

    public JwtToken(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}