package com.tianbao.points.app.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created with IntelliJ IDEA
 *
 * @author lushusheng
 * @Description jwt token
 * @Date 2018-12-12
 * @Time 16:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
}