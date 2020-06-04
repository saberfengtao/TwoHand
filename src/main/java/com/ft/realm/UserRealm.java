package com.ft.realm;


import com.ft.entity.Admin;
import com.ft.entity.Authority;
import com.ft.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    /**
     * 为当前登陆的用户授权
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        Admin admin=(Admin)subject.getPrincipal();
        List<Authority> authorityList=adminService.getAuthoritiesByAdminName(admin.getAdminLoginName());

        //循环为用户添加权限
        for(Authority authority:authorityList) {
            if(authority==null){continue;}//判断为空的跳过，适用于为用户配置多个角色
            info.addStringPermission(authority.getAuthoPerms());
        }
        return info;
    }

    /**
     * 为当前登陆用户进行身份验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        Admin admin =adminService.getAdminByLoginName((token.getUsername()));
        //验证用户名
        /*System.out.println("到这了吗");*/
        if(admin==null || !token.getUsername().equals(admin.getAdminLoginName())) {
            //返回空则内部会报UnknownAccountException异常
            /*System.out.println("没有查到用户， 查到的与传来的不一致");*/
            return null;
        }

        return new SimpleAuthenticationInfo(admin,admin.getAdminLoginPwd(),"");
    }

    // 清除缓存
    public void clearCached() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }

}
