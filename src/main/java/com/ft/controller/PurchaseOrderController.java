package com.ft.controller;

import com.ft.entity.PurchaseOrder;
import com.ft.service.PurchaseOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @Resource
    PurchaseOrderService purchaseOrderService;

    /**
     * 用户查看卖货单（user）
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/getAllPurchaseOrderByUserId")
    public String updUserByAdminId(String userId, Model model) {
       List<PurchaseOrder> purchaseOrderList= purchaseOrderService.getAllPurchaseOrderByUserId(userId);
        model.addAttribute("purchaseOrderList", purchaseOrderList);
        return "system/user/good/showOwnPurchaseOrder";
    }


    @RequestMapping("/delPurchaseOrder")
    public String delPurchaseOrder(String orderId,String orderState, Model model) {
        if(purchaseOrderService.updPurchaseOrderStateByOrderStateAndOrderID(orderState,orderId)){
            model.addAttribute("msg", "删除数据成功");
            return "success";
        } else {
            return "error";}


    }

}
