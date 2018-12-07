package com.tianbao.points.admin.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <P></P>
 *
 * @author zhaodong
 * @version v1.0
 * @email zhaodongxx@outlook.com
 * @since 2018/3/30 22:41
 */
//@Configuration
public class ShiroConfig {
    /**
     * 自定义的Realm
     */
    @Bean(name = "customRealm")
    public CustomRealm customRealm(){
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(customRealm());
        return securityManager;
    }
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("logout", "logout");
        filterChainDefinitionMap.put("/user/login", "anon");
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/user/**", "anon");
        filterChainDefinitionMap.put("/test/**", "authc");
        filterChainDefinitionMap.put("/page/**", "authc");        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面          shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/page/fail.html");//未授权跳转
        //登录成功跳转的链接 (这个不知道怎么用，我都是自己实现跳转的)
        shiroFilterFactoryBean.setSuccessUrl("/page/main.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 凭证匹配器
     * 由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }


//    @Bean
//    public UserRealm myShiroRealm() {
//        UserRealm myShiroRealm = new UserRealm();
//        //使用加密
//        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return myShiroRealm;
//    }

//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        return securityManager;
//    }


    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 注册全局异常处理
     * @return
     */
//    @Bean(name = "exceptionHandler")
//    public HandlerExceptionResolver handlerExceptionResolver() {
//        return new ExceptionHandler();
//    }
}

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


//@Configuration
//public class ShiroConfig {
//
//    @Bean("securityManager")
//    public DefaultWebSecurityManager getManager(MyRealm realm) {
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        // 使用自己的realm
//        manager.setRealm(realm);
//
//        /*
//         * 关闭shiro自带的session，详情见文档
//         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
//         */
//        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
//        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
//        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
//        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
//        manager.setSubjectDAO(subjectDAO);
//
//        return manager;
//    }
//
//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
//        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
//
//        // 添加自己的过滤器并且取名为jwt
//        Map<String, Filter> filterMap = new HashMap<>();
//        filterMap.put("jwt", new JWTFilter());
//        factoryBean.setFilters(filterMap);
//
//        factoryBean.setSecurityManager(securityManager);
//        factoryBean.setUnauthorizedUrl("/401");
//
//        /*
//         * 自定义url规则
//         * http://shiro.apache.org/web.html#urls-
//         */
//        Map<String, String> filterRuleMap = new HashMap<>();
//        // 所有请求通过我们自己的JWT Filter
//        filterRuleMap.put("/**", "jwt");
//        // 访问401和404页面不通过我们的Filter
//        filterRuleMap.put("/401", "anon");
//        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
//        return factoryBean;
//    }
//
//    /**
//     * 下面的代码是添加注解支持
//     */
//    @Bean
//    @DependsOn("lifecycleBeanPostProcessor")
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        // 强制使用cglib，防止重复代理和可能引起代理出错的问题
//        // https://zhuanlan.zhihu.com/p/29161098
//        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
//        return defaultAdvisorAutoProxyCreator;
//    }
//
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }
//}