package com.ft.controller;


import com.ft.entity.Good;
import com.ft.entity.GoodType;
import com.ft.entity.SaleOrder;
import com.ft.service.GoodService;
import com.ft.service.GoodTypeService;
import com.ft.service.SaleOrderService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/saleOrder")
public class SaleOrderController {

    @Resource
    GoodTypeService goodTypeService;

    @Resource
    GoodService goodService;

    @Resource
    SaleOrderService saleOrderService;

    /**
     * 查勋卖货单通过物品id
     * @return
     */
    @RequestMapping("/toGetSaleOrderMessageByGoodId")
    public String updUserByAdminId(String goodId, Model model) {
        SaleOrder saleOrder=saleOrderService.getSaleOrderByGoodId(goodId);
        System.out.println(saleOrder.getSoId());
        model.addAttribute("saleOrder", saleOrder);
        System.out.println("来来来买东西");
        return "system/user/good/userBuyGood";
    }

    /**
     * 用户购买逻辑处理
     * @param saleOrder
     * @param goodId
     * @param outUserId
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/buyGoodOverOrder")
    public String buyGoodOverOrder(SaleOrder saleOrder,String goodId,String outUserId,String userId,Model model) {
        System.out.println(saleOrder.getSoState());
        if (saleOrderService.updSoleOrderBySoIdForFinish(saleOrder,userId,goodId,outUserId)){
            model.addAttribute("msg", "购买成功快去个人中心看看吧");
            List<GoodType> goodTypeList=goodTypeService.getAllGoodTypes();
            List<Good> goodList=goodService.getAllGood();
            model.addAttribute("goodList",goodList);
            model.addAttribute("goodTypeList",goodTypeList);
            return "user/twoHandIndex";
        }

        return "error";
    }


    @RequestMapping("/getAllSaleOrderFinishByUserId")
    public String getAllSaleOrderFinishByUserId(String userId,Model model){

        List<SaleOrder> saleOrderList= saleOrderService.getAllSaleOrderByUserId(userId);
        model.addAttribute("saleOrderList", saleOrderList);
        return "system/user/good/showOwnSaleOrder";
    }

    @RequestMapping("/delSaleOrder")
    public String delsaleOrder(String orderId, Model model) {
        if(saleOrderService.updSaleOrderStateByOrderId(orderId)){
            model.addAttribute("msg", "删除数据成功");
            return "success";
        } else {
            return "error";}


    }

}
