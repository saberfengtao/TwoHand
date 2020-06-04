package com.ft.controller;


import com.ft.entity.Good;
import com.ft.entity.GoodType;
import com.ft.service.GoodService;
import com.ft.service.GoodTypeService;
import com.ft.utils.ImageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("/good")
@Controller
public class GoodController {

    @Resource
    GoodService goodService;

    @Resource
    GoodTypeService goodTypeService;


    @RequestMapping("/addGoodType")
    public String addGoodType(String goodTypeName,Model model){
        if (goodTypeService.addGoodType(goodTypeName)){
     return "redirect:/basic/toAddGoodType";}
        model.addAttribute("msg","添加失败");
        return "error";
    }

    @RequestMapping("/delGoodType")
    public String delGoodType(String goodTypeId,Model model){
        if (goodTypeService.delGoodType(goodTypeId)){
            return "redirect:/basic/toAddGoodType";}
        model.addAttribute("msg","删除失败");
        return "error";
    }

    @RequestMapping("/getGoodByGoodTypeId")
    public String getGoodByGoodTypeId(String goodTypeId, Model model) {
        //1.得到物品类型分类,
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
        //2.根据物品的类型ID查询物品
        List<Good> goodListByGoodTypeId=goodService.getAllGoodsByGoodTypeId(goodTypeId);
        //得到全部物品

        //List<Good> goodList=goodService.getAllGood();
        model.addAttribute("goodTypeList",goodTypeList);
        model.addAttribute("goodListByGoodTypeId",goodListByGoodTypeId);
        //model.addAttribute("goodList",goodList);
        int goodTypeIdC = Integer.parseInt(goodTypeId);
        model.addAttribute("sbId",goodTypeIdC);
        return "user/twoHandGoodShow";
    }
    @RequestMapping("/addGoodFromAdmin")
    public String addGoodFromAdmin(HttpServletRequest request,Good good, String goodTypeId, String adminId, Model model) {
        //查询所有的商品类型
        //goodService.addGoodFromAdmin(good,goodTypeId,adminId);
        System.out.println("到这了吗");
        System.out.println("图片格式："+good.getFilePath());
        //将照片上传到服务器
        // 得到上传图片的地址
        String imgPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, good.getFilePath());
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                good.setGoodPhoto(imgPath);
                if (goodService.addGoodFromAdmin(good,goodTypeId,adminId)){
                    model.addAttribute("msg","发布物品信息成功");
                    return "success";
                }
                System.out.println(good.getGoodPhoto()+"-----------------图片上传成功！");
                model.addAttribute("msg","发布二手物品失败");
                return "error";
            } else {
                model.addAttribute("msg","发布二手物品失败，未添加图片");
                System.out.println("-----------------图片上传失败！");
                return "error";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
        return "success";
    }

    @RequestMapping("/updGoodFromUser")
    public String updGoodFromUser(HttpServletRequest request,Good good, String goodTypeId, Model model) {
        String imgPath;
        try {
            imgPath = ImageUtils.upload(request, good.getFilePath());
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                good.setGoodPhoto(imgPath);
                if (!goodService.updGoodFromUser(good,goodTypeId)){
                    model.addAttribute("msg","修改信息失败");
                    return "error";
                }
                System.out.println(good.getGoodPhoto()+"-----------------图片上传成功！");
            } else{
                if(!goodService.updGoodFromUser(good,goodTypeId)){
                    model.addAttribute("msg","修改信息失败");
                    return "error";
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
        model.addAttribute("msg","修改信息成功");
        return "success";
    }

    @RequestMapping("/addGoodFromUser")
    public String addGoodFromUser(HttpServletRequest request,Good good, String goodTypeId, String userId, Model model) {
        //查询所有的商品类型
        //goodService.addGoodFromAdmin(good,goodTypeId,adminId);
        //将照片上传到服务器
        // 得到上传图片的地址
        String imgPath;
        try {
            //ImageUtils为之前添加的工具类
            imgPath = ImageUtils.upload(request, good.getFilePath());
            if (imgPath != null) {
                // 将上传图片的地址封装到实体类
                good.setGoodPhoto(imgPath);
                if (goodService.addGoodFromUser(good,goodTypeId,userId)){
                    model.addAttribute("msg","发布物品信息成功");
                    return "success";
                }
                System.out.println(good.getGoodPhoto()+"-----------------图片上传成功！");
                model.addAttribute("msg","发布二手物品失败");
                return "error";
            } else {
                System.out.println("-----------------图片上传失败！");
                model.addAttribute("msg","发布二手物品失败,未添加图片");
                return "error";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("----------------图片上传失败！");
        }
        return "success";
    }

    @RequestMapping("/updGoodStateByMl")
    public String updGoodStateByMl(String ml) {

        return  goodService.updGoodStateByMl(ml);
    }

    @RequestMapping("/delGood")
    public String delGood(String goodId,Model model){
        if (goodService.delGoodAndSaleOrderByGoodId(goodId)){
            model.addAttribute("msg","删除物品成功");
        return "success";}
        model.addAttribute("msg","删除物品失败");
         return "error";
    }

    @RequestMapping("/findGoodByGoodNameX")
    public String findGoodByGoodNameX(String goodNameX,Model model){
        //1.得到物品类型分类
        List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
        //2.根据物品的名字判断进行模糊查询
        List<Good> goodListByGoodNameX=goodService.goodListByGoodNameX(goodNameX);

        model.addAttribute("goodTypeList",goodTypeList);
        model.addAttribute("goodListByGoodTypeId",goodListByGoodNameX);
        return "user/twoHandGoodShow";
    }


}
