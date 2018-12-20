package com.tianbao.points.app.config.shiro;

//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * <P></P>
// *
// * @author zhaodong
// * @version v1.0
// * @email zhaodongxx@outlook.com
// * @since 2018/3/30 22:41
// */
////@Configuration
//public class ShiroConfig {
//    /**
//     * 自定义的Realm
//     */
//    @Bean(name = "customRealm")
//    public CustomRealm customRealm(){
//        CustomRealm customRealm = new CustomRealm();
//        return customRealm;
//    }
//    @Bean
//    public DefaultWebSecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
//        //设置realm.
//        securityManager.setRealm(customRealm());
//        return securityManager;
//    }
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //拦截器.
//        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
//        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("logout", "logout");
//        filterChainDefinitionMap.put("/user/login", "anon");
//        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
//        filterChainDefinitionMap.put("/user/**", "anon");
//        filterChainDefinitionMap.put("/test/**", "authc");
//        filterChainDefinitionMap.put("/page/**", "authc");        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面          shiroFilterFactoryBean.setLoginUrl("/login.html");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/page/fail.html");//未授权跳转
//        //登录成功跳转的链接 (这个不知道怎么用，我都是自己实现跳转的)
//        shiroFilterFactoryBean.setSuccessUrl("/page/main.html");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 凭证匹配器
//     * 由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
//     * @return
//     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
//        return hashedCredentialsMatcher;
//    }
//
//
////    @Bean
////    public UserRealm myShiroRealm() {
////        UserRealm myShiroRealm = new UserRealm();
////        //使用加密
////        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
////        return myShiroRealm;
////    }
//
////    @Bean
////    public SecurityManager securityManager() {
////        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
////        securityManager.setRealm(myShiroRealm());
////        return securityManager;
////    }
//
//
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
//        return new LifecycleBeanPostProcessor();
//    }

    /**
     * 注册全局异常处理
     * @return
     */
//    @Bean(name = "exceptionHandler")
//    public HandlerExceptionResolver handlerExceptionResolver() {
//        return new ExceptionHandler();
//    }
//}

/**
 * Shiro配置类
 * 1.配置ShiroFilterFactory 2.配置SecurityManager
 * @author zhengkai
 *
 */
//@Configuration
//public class ShiroConfig {
//    /**
//     * 配置shiro过滤器
//     * @author zhengkai
//     */
//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        //1.定义shiroFactoryBean
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//        //2.设置securityManager
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //3.LinkedHashMap是有序的，进行顺序拦截器配置
//        Map<String,String> filterChainMap = new LinkedHashMap<String,String>();
//        //4.配置logout过滤器
//        filterChainMap.put("/logout", "logout");
//        //5.所有url必须通过认证才可以访问
//        filterChainMap.put("/**","authc");
//        //6.设置默认登录的url
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        //7.设置成功之后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        //8.设置未授权界面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        //9.设置shiroFilterFactoryBean的FilterChainDefinitionMap
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
//        return shiroFilterFactoryBean;
//    }
//    /**
//     * 配置安全管理器
//     * @author zhengkai
//     */
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        return securityManager;
//    }
//
//}

import com.tianbao.points.app.config.jwt.JwtFilter;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author lushusheng
 * @description shiro权限配置
 * @date 2018-12-10
 * @time 14:12
 */
@Configuration
public class ShiroConfig {

    /**
     *
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    /**
     * 下面的代码是添加注解支持
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
        // https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * @author lushusheng
     * @description 创建ShiroFilterFactoryBean
     * @date 2018-12-10
     * @time 14:12
     */
    /**
     * 常用的过滤器：
     * anon: 无需认证（登录），匿名即可登录
     * authc: 必须认证（登录）才可以访问
     * user: 用于rememberMe功能，可以直接访问
     * perms: 该资源必须得到资源权限才能访问
     * role: 该资源必须得到角色权限才能访问
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //第一项设置参数,关联安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * 自定义url规则
         * http://shiro.apache.org/web.html#urls-
         */
        //LinkedHashMap是有序的，进行顺序拦截器配置
        Map<String, String> filterRuleMap = new LinkedHashMap<>();
        //添加shiro内置过滤器,可以实现权限相关的拦截器
        //filterRuleMap.put("/announcement/list/page", "authc");
        filterRuleMap.put("/security/login", "anon");
        //filterRuleMap.put("/**", "anon");
        //filterMap.put("/*", "authc");
        //授权过滤器
        //注意，当授权未通过时，会跳转到默认的未授权页面
        filterRuleMap.put("/announcement/list/page", "perms[announcement:list]");
        //修改登录页面
        //shiroFilterFactoryBean.setLoginUrl();
        //设置未授权的提示错误页面
        //shiroFilterFactoryBean.setUnauthorizedUrl();
        // 添加自己的过滤器并且取名为jwt
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwt", new JwtFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        // 所有请求通过我们自己的JWT Filter
        filterRuleMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return shiroFilterFactoryBean;
    }

    /**
     * @author lushusheng
     * @description 创建DefaultWebSecurityManager
     * @date 2018-12-10
     * @time 14:12
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("customRealm") CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(customRealm);
        return securityManager;
    }
    /**
     * @author lushusheng
     * @description 注入自定义Realm
     * @date 2018-12-10
     * @time 14:12
     */
    @Bean(name = "customRealm")
    public CustomRealm getCustomRealm() {
        return new CustomRealm();
    }

    /**
     *
     */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}