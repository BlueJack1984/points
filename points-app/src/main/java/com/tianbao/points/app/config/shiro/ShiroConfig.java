package com.tianbao.points.app.config.shiro;

import com.tianbao.points.app.config.jwt.JwtFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
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
     *下面的代码注入生命周期处理器bean
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
        filterRuleMap.put("/security/login", "anon");
        filterRuleMap.put("/security/captcha/generate", "anon");
        filterRuleMap.put("/security/article", "anon");
        filterRuleMap.put("/401", "anon");
        filterRuleMap.put("/402", "anon");
        filterRuleMap.put("/403", "anon");
        filterRuleMap.put("/404", "anon");

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
        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

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
     *注入AuthorizationAttributeSourceAdvisor
     */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}