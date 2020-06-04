package com.ft.controller;

import com.ft.entity.User;
import com.ft.service.UserService;
import com.ft.utils.SendMessageService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 用户登录
     * @param user
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value="/userLogin")
    public String userLogin(User user, HttpSession session , Model model) {
        User user1=userService.userLogin(user);
        System.out.println(user.getUserLoginName()+"和"+user.getUserLoginPwd());
        if(user1==null){
            model.addAttribute("msg","登录失败！账号或密码错误");
            return "user/user_login";
        }
        else {
            if(user1.getUserState()!=0){
                model.addAttribute("msg","该账户已被冻结！");
                return "user/user_login";
            }
            session.setAttribute("user",user1);
            return "redirect:/basic/toTwoHandIndex";//调试完成后改跳转路径
        }
    }

    /**
     * 用户名判重
     * @param userLoginName
     * @return
     */
    @RequestMapping("/haveUserLoginName")
    @ResponseBody
    public String haveUserLoginName(String userLoginName){
        System.out.println("跳转");
        if (userLoginName.length()==0){ return "null";}
        else if (userService.haveUserLoginName(userLoginName)){
            System.out.println("true");
            return "true";
        }
        else{
            System.out.println("false");
            return "false";}

    }

    //对注册的邮箱判重如果不重发送邮件

    /**
     * 发送邮件
     * @param userEmail
     * @return
     */
    @RequestMapping("/getEmailVerify")
    @ResponseBody
    public String getEmailVerify(String userEmail){
        System.out.println("从前台接受的邮箱号："+userEmail);
        //if结果为真表示没查到邮箱对应用户，可发送验证码给邮箱
        if(userService.getMailFindUser(userEmail)){
            //1.ver生成6位随机数
            int ver1=(int)(Math.random() * 899999)+100000;
            String ver = String.valueOf(ver1);
            //2.调用邮箱接口
            SendMessageService sendMessageService=new SendMessageService();
            //2.将验证码和邮箱号传入接口实现发邮件
            sendMessageService.sendmessage(userEmail,ver1);
            return ver;
        }else{
            return "当前邮箱已绑定用户，请更换邮箱";}
    }

    /**
     * 用户注册
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value="/userRegister",method = RequestMethod.POST)
    public String userRegister(User user,Model model) {

        if(userService.userRegister(user)){
            model.addAttribute("msg","注册成功");
            return "success";
        }else{
            model.addAttribute("msg","注册失败");
            return "error";
        }
    }



//-------------下面关于用户部分system功能的跳转

    /**
     * 跳转到修改密码界面，未用嵌套模板
     * @return
     */
    @RequestMapping("/updUserPwdByUserId")
    public String updUserPwdByUserId() {

        return "system/user/updOwnPass";
    }

    /**
     * 跳转到修改密码界面，未用嵌套模板
     * @return
     */
    @RequestMapping("/toOwnShopCart")
    public String toOwnShopCart() {

        return "system/user/good/ownShopCart";
    }


    /**
     * 跳转到修改基本信息
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/updUserMessageByUserId")
    public String updUserMessageByUserId(User user, Model model) {
        System.out.println("得到用户的登录名"+user.getUserLoginName());

        //1.通过登录名查找用户
        //2.将查找到的用户打包在model中
        User user1=userService.getUserByUserLoginName(user.getUserLoginName());
        if (user1!=null){
            model.addAttribute("user",user1);
            return "system/user/updOwnMessage";
        }
        model.addAttribute("msg","去到需要修改用户信息失败！");
        return "error";
    }

    /**
     * 跳转到修改基本信息
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/getUserMessageByUserId")
    public String getUserMessageByUserId(User user, Model model) {

        User user1=userService.getUserByUserLoginName(user.getUserLoginName());
        if (user1!=null){
            model.addAttribute("user",user1);
            return "system/user/showOwnMessage";
        }
        model.addAttribute("msg","去到需要修改用户信息失败！");
        return "error";
    }

    @RequestMapping("/updUserState")
    public String updUserState(String id,String x,Model model){
        System.out.println(id);
        System.out.println(x);
        if(userService.updUserState(id,x)){
            return "redirect:/basic/getUserListFormAdmin";
        }
        model.addAttribute("msg","禁用失败");
        return "error";
    }
}
