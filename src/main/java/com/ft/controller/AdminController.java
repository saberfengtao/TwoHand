package com.ft.controller;

import com.ft.entity.Admin;
import com.ft.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;


    //管理员登录
    @RequestMapping(value="/adminLogin")
    public String adminLogin(Admin admin,HttpSession session , Model model) {
        if (adminService.getAdminByLoginName(admin.getAdminLoginName()).getAdminState() != 0) {
            model.addAttribute("msg", "该账户已被冻结");
            return "/admin_login";
        } else {
            //1.获取当前主体
            Subject subject = SecurityUtils.getSubject();
            //2.封装用户数据到token，token表示令牌
            UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminLoginName(), admin.getAdminLoginPwd());
            //3.登陆
            try {
                subject.login(token);
                Admin user = (Admin) SecurityUtils.getSubject().getPrincipal();
                System.out.println(user.getAdminId() + "+" + user.getAdminState());
                session.setAttribute("admin", user);
            } catch (UnknownAccountException e) {
                /*e.printStackTrace();*/
                //该异常表示用户名不存在
                model.addAttribute("msg", "账号或密码错误");
                return "/admin_login";
            } catch (IncorrectCredentialsException e) {
                //表示密码错误
                /* e.printStackTrace();*/
                model.addAttribute("msg", "账号或密码错误");
                return "/admin_login";
            } catch (AuthenticationException e) {
                //表示认证失败
                /*e.printStackTrace();*/
                model.addAttribute("msg", "账号或密码错误");
                return "/admin_login";
            }
            System.out.println("登陆成功");
            return "redirect:/toAdminHome";
        }
    }

    //对注册的登录名查重
    @RequestMapping("/haveName")
    @ResponseBody
    public String haveName(String adminLoginName){
       /* System.out.println("判重");
        System.out.println("为空"+adminLoginName);*/
        if(adminLoginName.length()==0){
            //System.out.println("用户名为空");
            return "null";}
        else
        if(!adminService.findAdminByName(adminLoginName)){
            return "true";
        }else{
            return "false";
        }
    }

    //对创建或修改角色查重
    @RequestMapping("/haveRole")
    @ResponseBody
    public String haveRole(String roleName){
       // System.out.println("判重");
       // System.out.println("为空"+roleName);
        if(roleName.length()==0){
            /*System.out.println("用户名为空");*/
            return "null";}
        else
        if(!adminService.findRoleByName(roleName)){
            System.out.println("true");
            return "true";
        }else{
            System.out.println("false");
            return "false";
        }
    }


}
