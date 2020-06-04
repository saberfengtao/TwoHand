package com.ft.service;

import com.ft.entity.SaleOrder;

import java.util.List;

public interface SaleOrderService {

    /**
     * 得到所有的买货单
     * @return
     */
    List<SaleOrder> getAllSaleOrder();

    /**
     * 所有的订单通过用户ID
     * @return
     */
    List<SaleOrder> getAllSaleOrderByUserId(String userId);

    /**
     * 通过物品ID查询卖货单
     * @return
     */
    SaleOrder getSaleOrderByGoodId(String goodId);

    /**
     * 完成购买逻辑判断
     * @param soleOrder
     * @param userId
     * @param goodId
     * @param outUserId
     * @return
     */
    Boolean updSoleOrderBySoIdForFinish(SaleOrder soleOrder,String userId,String goodId,String outUserId);


    /**
     * 修改卖货单状态达到删除
     * @param orderId
     * @return
     */
    boolean updSaleOrderStateByOrderId(String orderId);


}
