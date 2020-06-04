package com.ft.service;

import com.ft.entity.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    /**
     * 通过用ID所有的买货单（用户身份为买入者）
     * @return
     */
    List<PurchaseOrder> getAllPurchaseOrderByUserId(String inUserId);

    /**
     * 得到所有的买货单（管理员用）
     * @return
     */
    List<PurchaseOrder> getAllPurchaseOrder();

    /**
     * 删除操作，将订单转台转为用户不可见（修改买货单状态）
     * @return
     */
    boolean updPurchaseOrderStateByOrderStateAndOrderID(String orderState, String orderId);
}
