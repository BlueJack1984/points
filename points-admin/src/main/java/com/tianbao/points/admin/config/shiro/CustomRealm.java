package com.tianbao.points.admin.config.shiro;

import com.tianbao.points.admin.security.JwtToken;
import com.tianbao.points.core.entity.Authority;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IAuthorityService;
import com.tianbao.points.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @author lushusheng
 * @description 自定义Realm
 * @date 2018-12-10
 * @time 14:12
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userServer;
    @Autowired
    private IAuthorityService authorityServer;
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
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JwtToken;
//    }

    /**
     * @author lushusheng
     * @description 用于授权,只有当需要检测用户权限的时候才会调用此方法
     * 权限信息，包括角色以及权限
     * @date 2018-12-10
     * @time 14:12
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        //String username = JwtUtil.getUsername(principals.toString());
        /**
         * 如果身份认证的时候没有传入User对象，这里只能取到userName
         * 也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
         */
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User current = (User)principalCollection.getPrimaryPrincipal();
        //查询用户的权限列表
        List<Authority> authorityList = null;
        try {
            authorityList = authorityServer.getListByUserId(current.getId());
        } catch (ApplicationException e) {
            log.info(e.getDetailMsg());
            return simpleAuthorizationInfo;
        }
        //授权列表
        Set<String> permissionSet = new HashSet<>();
        for(Authority authority: authorityList) {
            if(authority == null) {
                continue;
            }
            permissionSet.add(authority.getPermission());
        }
        // 给资源进行授权
        simpleAuthorizationInfo.addStringPermissions(permissionSet);
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
        //String token = (String) authenticationToken.getCredentials();
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
        try {
            user = userServer.getByAccount(username);
        } catch (ApplicationException e) {
            log.info(e.getDetailMsg());
            return null;
        }
        if(user == null) {
            return null;
        }
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}