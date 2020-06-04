package com.ft.controller;

import com.ft.entity.Good;
import com.ft.entity.GoodType;
import com.ft.entity.User;
import com.ft.service.GoodService;
import com.ft.service.GoodTypeService;
import com.ft.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/basic")
@Controller
//存放判断重复，跳转及一些接口
public class BasicController {

    @Resource
    GoodTypeService goodTypeService;

    @Resource
    GoodService goodService;

    @Resource
    UserService userService;

    /**
     * 跳转到添加物品的页面（admin）
     * @return
     */
    @RequestMapping("/addGood")
    public String addGood(Model model) {
        //查询所有的商品类型
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
        model.addAttribute("goodTypeList",goodTypeList);
        System.out.println("跳转到添加物品页面");
        return "system/admin/good/addGood";
    }

    /**
     * 跳转到物品列表的页面（admin）
     * @return
     */
    @RequestMapping("/toGetAllGood")
    public String toGetAllGood(Model model) {
        //查询所有的商品类型
        List<Good> goodList=goodService.getAllGood();
        model.addAttribute("goodList",goodList);
        return "system/admin/good/goodManage";
    }

    /**
     * 跳转到添加物品类型的页面（admin）
     * @return
     */
    @RequestMapping("/toAddGoodType")
    public String addGoodType(Model model) {
        //查询所有的商品类型
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();

        model.addAttribute("goodTypeList",goodTypeList);
        System.out.println("跳转到添加物品类型页面");
        return "system/admin/good/addGoodType";
    }


    /**
     * 跳转到添加物品的页面（user）
     * @return
     */
    @RequestMapping("/addGoodFromUser")
    public String addGoodFromUser(Model model) {
        //查询所有的商品类型
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
        model.addAttribute("goodTypeList",goodTypeList);
        System.out.println("跳转到添加物品页面");
        return "system/user/good/addGood";
    }

    /**
     * 跳转到更改物品的页面（user）
     * @return
     */
    @RequestMapping("/toUpdGoodMessageFromUser")
    public String toUpdGoodMessageFromUser(String goodId,Model model,String x) {
        //查询所有的商品类型
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
        System.out.println(goodId);
        Good good = goodService.getGoodByGoodId(goodId);
        model.addAttribute("goodTypeList",goodTypeList);
        model.addAttribute("good",good);
        System.out.println("跳转到添加物品页面");
        if(x!=null){
            return "system/admin/good/updGood";
        }else{
        return "system/user/good/updGood";}
    }


    /**
     * 查询用已户发布未卖出的二手物品信息
     * @param model
     * @return
     */
    @RequestMapping("/getSaleUserMessageByGoodId")
    public String getSaleUserMessageByGoodId(Model model,String userId) {
        //查询所有的商品类型
        List<Good> goodList=goodService.getSaleGoodByUserId(userId);
        model.addAttribute("goodList",goodList);
        System.out.println("跳转到添加物品页面");
        return "system/user/good/showOwnGood";
    }



    @RequestMapping("/getUserListFormAdmin")
    public String getUserListFormAdmin(Model model) {
        List<User> userList=userService.getAllUser();
        model.addAttribute("userList",userList);
        return "system/admin/user/userWManage";
    }


    /**
     * 测试项
     * @return
     */
    @RequestMapping("/info")
    public String info() {
        return "user/addAdmin";
    }

    /**
     * 去到用户登录界面(admin)
     * @return
     */
    @RequestMapping("/toAdminLogin")
    public String toAdminLogin() {

        return "admin_login";
    }

    /**
     * 去到用户登录界面(user)
     * @return
     */
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {

        return "user/user_login";
    }

    /**
     * 去当网站首页
     * @return
     */
    @RequestMapping("/toTwoHandIndex")
    public String toTwoHandIndex(Model model) {
        //添加查询的物品类型和物品的集合
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
        List<Good> goodList=goodService.getAllGood();
        model.addAttribute("goodList",goodList);
        model.addAttribute("goodTypeList",goodTypeList);
        return "user/twoHandIndex";
    }

    /**
     * 去到用户界面注册(user)
     * @return
     */
    @RequestMapping("/toUserRegister")
    public String toUserRegister() {

        return "user/userRegister";
    }



}
