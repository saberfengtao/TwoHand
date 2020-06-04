package com.ft.mapper;

import com.ft.entity.Good;
import com.ft.entity.SaleOrder;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface SaleOrderMapper {


    /**
     * 添加买货单（admin）
     * @param good
     * @param soTimeStart
     * @param adminId
     * @return
     */
    int addSaleOrderFromAdmin(@Param("good")Good good, @Param("soTimeStart")Timestamp soTimeStart, @Param("adminId")int adminId);

    /**
     * 添加买货单（user）
     * @param good
     * @param soTimeStart
     * @param userId
     * @return
     */
    int addSaleOrderFromUser(@Param("good")Good good, @Param("soTimeStart")Timestamp soTimeStart, @Param("userId")int userId);

    /**
     * 得到卖货单通过物品id
     * @param goodId
     * @return
     */
    SaleOrder getSaleOrderByGoodId(int goodId);

    /**
     * 修改卖货单状态完成交易
     * @param saleOrder
     * @return
     */
    int updSaleOrderStateForFinish(@Param("saleOrder")SaleOrder saleOrder,int userId);

    /**
     * 所有的订单(卖货单)通过用户ID
     * @return
     */
    List<SaleOrder> getAllSaleOrderByUserId(int userId);

    /**
     * 修改卖货单状态达到删除
     * @param orderId
     * @return
     */
    boolean updSaleOrderStateByOrderId(int orderId);

    /**
     * 通过物品ID删除卖货单
     * @param goodId
     * @return
     */
    int deleteSaleOrderByGoodId(int goodId);

}
