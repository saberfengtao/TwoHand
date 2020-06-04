package com.ft.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ft.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 1.注入UserRealm
     * @return
     */
    @Bean("userRealm")
    public UserRealm getReal() {
        return new UserRealm();
    }

    /**
     * 2.创建过滤器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        //创建ShiroFilterFactory对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全会话管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //a、anon：无需认证，直接就可以访问
        //b、authc：必须认证才可以访问
        //c、user：如果使用rememberMe的功能可以直接访问
        //d、perms：必须有资源权限才可以访问
        //e、 role：必须得到角色权限才可以访问
        //创建Map集合，保存各种需要处理的请求
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/system/addUser","perms[system:addUser]");
        map.put("/system/updUser","perms[system:updUser]");
        map.put("/system/addRole","perms[system:addRole]");
        map.put("/system/updRole","perms[system:updRole]");
        map.put("/system/roleManage","perms[system:roleManage]");
        map.put("/system/userManage","perms[system:userManage]");
        map.put("/toUpdOwnPass","perms[system:updPass]");

        map.put("/basic/toAddGoodType","perms[basic:addGoodType]");
        map.put("/basic/addGood","perms[basic:addGood]");
        map.put("/basic/toGetAllGood","perms[basic:toGetAllGood]");
        map.put("/basic/getUserListFormAdmin","perms[basic:userList]");
        /*map.put("/basic/column","perms[basic:column]");
        map.put("/basic/add/adv","perms[basic:adv:add]");
        map.put("/basic/del/adv","perms[basic:adv:del]");
        map.put("/basic/upd/adv","perms[basic:adv:upd]");*/


       // map.put("/system/addRole","perms[ system:updPass]");

        map.put("/toAdminHome","authc");//这个跳转要有登录的人
        /**************设置放行anon请求********************/
        map.put("/users/tologin","anon");
        map.put("/user","anon");
        map.put("/users/login","anon");
        //map.put("/admin/adminLogin","anon");

        //放行的页面
        map.put("admin_login.html","anon");//管理员登陆页面
        map.put("toTwoHandIndex","anon");//登陆页面
       /* map.put("user/user_login.html","anon");//登陆页面
        map.put("user/userRegister.html","anon");//登陆页面*/
        map.put("index.html","anon");//去到首页
        /*放行页面end*/

       // map.put("/admin","authc");
        //map.put("/system/admin","authc");
        /**************设置身份验证authc请求********************/
       // map.put("/users/login","anon");

        //允许访问静态资源
        map.put("/static/**","anon");

        //设置过滤器链
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //设置登录页面请求（想进任何页面无权限跳到登录页面）
        shiroFilterFactoryBean.setLoginUrl("/basic/toAdminLogin");
        //登录后无权限跳转到下面法发
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthor");
        //返回shiroFilterFactoryBean
        return shiroFilterFactoryBean;

    }
    /**
     * 3.创建安全管理
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
       //创建DefaultWebSecurityManager对象
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联Realm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }


    /**
     * 创建ShiroDialect对象，用与thymeleaf和shiro标签配合使用
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        ShiroDialect shiroDialect = new ShiroDialect();
        return shiroDialect;
    }



}
