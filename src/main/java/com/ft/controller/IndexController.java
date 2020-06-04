package com.ft.controller;
import com.ft.entity.Admin;
import com.ft.entity.Good;
import com.ft.entity.GoodType;
import com.ft.entity.User;
import com.ft.service.AdminService;
import com.ft.service.GoodService;
import com.ft.service.GoodTypeService;
import com.ft.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;


@Controller
public class IndexController {

    @Resource
    AdminService adminService;

    @Resource
    UserService userService;

    @Resource
    GoodService goodService;

    @Resource
    GoodTypeService goodTypeService;

    /**
     * 正常登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        System.out.println("退出登录");
        return "admin_login";
    }

    /**
     * 修改密码重新登录（管理员）
     * @param model
     * @return
     */
    @RequestMapping("/logoutUpd")
    public String logoutUpt(Model model) {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        model.addAttribute("msg","认证过期，请重新登陆");
        return "user/twoHandIndex";
    }

    @RequestMapping("/updUserMessage")
    public String updUserMessage(HttpSession session ,Model model) {

        return "user/userLogin";
    }

    /**
     * 修改密码重新登录(用户)
     * @param model
     * @return
     */
    @RequestMapping("/logoutUptUser")
    public String logoutUptUser( HttpSession session , Model model) {
        Enumeration e=session.getAttributeNames();
        while(e.hasMoreElements()){ String sessionName=(String)e.nextElement();
            System.out.println("存在的session有："+sessionName);
            session.removeAttribute(sessionName); }
        //返回提示信息
        List<Good> goodList=goodService.getAllGood();
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
        model.addAttribute("goodList",goodList);
        model.addAttribute("goodTypeList",goodTypeList);
        model.addAttribute("msg","操作成功，您已退出登录");
        return "user/TwoHandIndex";//redirect:/toTwoHandIndex
    }

    /**
     * 欢迎页面 管理员
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome() {
        //System.out.println("返还登录页面");
        return "admin/welcome";
    }

    /**
     * 欢迎页面 用户
     * @return
     */
    @RequestMapping("/welcomeUser")
    public String welcomeUser() {

        return "user/welcomeUser";
    }


    /**
     * 欢迎页面 用户
     * @return
     */
    @RequestMapping("/userTip")
    public String userTip() {
        //System.out.println("返还登录页面");
        return "user/userTip";
    }

    /**
     * 测试用
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser() {
        //System.out.println("返还登录页面");
        return "admin/addUser";
    }

    /**
     * 管理员主页面
     * @return
     */
    @RequestMapping("/toAdminHome")
    public String toAdminHome() {
        return "admin/admin_home";
    }

    /**
     * 管理员添加用户
     * @return
     */
    @RequestMapping("/toAdminUser")
    public String toAdminUser() {

        return "system/admin/addUser";
    }

    //去更改个人密码页面
    @RequestMapping("/toUpdOwnPass")
    public String toUpdOwnPass(String adminLoginName,Model model){
        //System.out.println("hello  怕啊"+adminLoginName);
        Admin admin =adminService.getAdminByLoginName(adminLoginName);
        model.addAttribute("admin",admin);
        return "system/admin/updOwnPass";
    }
    //--------------------下面是用户的跳转-----------------------------》

    /**
     * 未经授权的页面
     * @return
     */
    @RequestMapping("/unAuthor")
    public String unAuthor() {
        return "unAuthor";
    }

    /**
     * 未经授权的页面
     * @return
     */
    @RequestMapping("/toFeedBack")
    public String toFeedBack() {


        return "system/user/addFeedBack";
    }

    /**
     * 登录成功后跳转到个人中心新
     * @return
     */
    @RequestMapping("/goUserHome")
    public String goUserHome(String userId,Model model){
        System.out.println("传过来的用户ID"+userId);
        User user=userService.getUserByUserLoginName(userId);
        if(user==null){
            model.addAttribute("msg","去到需要修改用户信息失败！");
            return "error";
        }
        //更改后重新取值
        model.addAttribute("user",user);
        return "user/user_home";
    }
}
