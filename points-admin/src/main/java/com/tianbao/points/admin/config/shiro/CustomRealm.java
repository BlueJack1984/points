package com.tianbao.points.admin.config.shiro;

import com.tianbao.points.admin.security.JwtToken;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @author lushusheng
 * @description 自定义Realm
 * @date 2018-12-10
 * @time 14:12
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userServer;
    /**
     * @author lushusheng
     * @description 无参构造方法，设置名称
     * @date 2018-12-11
     * @time 11:12
     */
    public CustomRealm() {
        setName("customRealm");
    }
    /**
     * @author lushusheng
     * @description 自定义Realm命名
     * @date 2018-12-10
     * @time 14:12
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * @author lushusheng
     * @description 用于授权,只有当需要检测用户权限的时候才会调用此方法
     * @date 2018-12-10
     * @time 14:12
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //String username = JwtUtil.getUsername(principals.toString());
        //SysUser user = sysUserService.findByUserName(username);
        //SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //return simpleAuthorizationInfo;
        //给资源进行授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //查询用户的权限列表
        //String username = principalCollection.
        //List<String>
        simpleAuthorizationInfo.addStringPermissions(null);
        //通过数据库查询
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return simpleAuthorizationInfo;
    }

    /**
     * @author lushusheng
     * @description 用于认证
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可
     * @date 2018-12-10
     * @time 14:12
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
//        // 解密获得username，用于和数据库进行对比
//        String username = JwtUtil.getUsername(token);
//        if (username == null) {
//            throw new AuthenticationException("token无效");
//        }
//
//        SysUser userBean = sysUserService.findByUserName(username);
//        if (userBean == null) {
//            throw new AuthenticationException("用户不存在!");
//        }
//
//        if (!JwtUtil.verify(token, username, userBean.getPassword())) {
//            throw new AuthenticationException("用户名或密码错误");
//        }
//
//        return new SimpleAuthenticationInfo(token, token, "my_realm");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        //从数据库中查询用户名和密码信息
        User user = null;
        if(user == null || ! username.equals(user.getAccount())) {
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}