package com.tianbao.points.admin.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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