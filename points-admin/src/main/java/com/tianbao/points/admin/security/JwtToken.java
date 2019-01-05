package com.tianbao.points.admin.security;

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
    private Long id;
    /**
     * 令牌数据
     */
    private String token;
    /**
     * 令牌有效期，毫秒
     */
    public JwtToken(String token) {
        this(null, token);
    }
    /**
     * 令牌有效期，毫秒
     */
    //private long expire;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
