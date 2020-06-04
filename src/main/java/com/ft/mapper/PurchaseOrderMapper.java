package com.ft.mapper;

import com.ft.entity.PurchaseOrder;
import com.ft.entity.SaleOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseOrderMapper {

    /**
     * 根据买货单生成买货单（完整订单）
     * @param saleOrder
     * @return
     */
    int addPurchaseBySoleOrder(@Param("saleOrder")SaleOrder saleOrder,int userId, int goodId, int outUserId);

    /**
     * 通过用ID所有的买货单（用户身份为买入者）
     * @return
     */
    List<PurchaseOrder> getAllPurchaseOrderByUserId(int inUserId);

    /**
     * 得到所有的买货单（管理员用）
     * @return
     */
    List<PurchaseOrder> getAllPurchaseOrder();

    /**
     * 删除操作，将订单转台转为用户不可见（修改买货单状态）
     * @return
     */
    int updPurchaseOrderStateByOrderStateAndId(int orderState,int orderId);
}
