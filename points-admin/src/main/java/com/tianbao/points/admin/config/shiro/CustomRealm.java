package com.tianbao.points.admin.config.shiro;

//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
//import javax.annotation.Resource;
//
///**
// *
// * @author zhaodong
// * @version v1.0
// * @email zhaodongxx@outlook.com
// * @since 2018/3/30 22:55
// */
//public class CustomRealm extends AuthorizingRealm {
//
//    //@Resource
//    //public ShiroService shiroService;
//
//    public CustomRealm(){
//        setName("customRealm");
//    }
//
//    public void setName(String name) {
//
//    }
//    /**
//     * 授权
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        return authorizationInfo;
//    }
//
//    /**
//     * 登录认证
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        //获取用户账号
//        String username = token.getPrincipal().toString();
//
//        //String password = shiroService.getPasswordByUsername(username);
//        String password = "hello";
//        if (password != null) {
//            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                    username,   //认证通过后，存放在session,一般存放user对象
//                    password,   //用户数据库中的密码
//                    getName());    //返回Realm名
//            return authenticationInfo;
//        }
//        return null;
//    }
//}