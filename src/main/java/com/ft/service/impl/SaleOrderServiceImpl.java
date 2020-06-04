package com.ft.service.impl;

import com.ft.entity.PurchaseOrder;
import com.ft.entity.SaleOrder;
import com.ft.mapper.GoodMapper;
import com.ft.mapper.PurchaseOrderMapper;
import com.ft.mapper.SaleOrderMapper;
import com.ft.mapper.UserMapper;
import com.ft.service.SaleOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SaleOrderServiceImpl implements SaleOrderService {
    @Resource
    UserMapper userMapper;

    @Resource
    GoodMapper goodMapper;

    @Resource
    SaleOrderMapper saleOrderMapper;

    @Resource
    PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public List<SaleOrder> getAllSaleOrder() {
        return null;
    }

    @Override
    public List<SaleOrder> getAllSaleOrderByUserId(String userId) {
        int userIdC = Integer.parseInt(userId);
        return saleOrderMapper.getAllSaleOrderByUserId(userIdC);
    }

    @Override
    public SaleOrder getSaleOrderByGoodId(String goodId) {
        int goodIdC = Integer.parseInt(goodId);
        return saleOrderMapper.getSaleOrderByGoodId(goodIdC);
    }

    @Override
    public Boolean updSoleOrderBySoIdForFinish(SaleOrder soleOrder,String userId,String goodId,String outUserId) {
        //zero 类型转换
        int userIdC = Integer.parseInt(userId);
        int goodIdC = Integer.parseInt(goodId);
        int outUserIdC = Integer.parseInt(outUserId);
        //1.更改完成交易的物品状态
        goodMapper.updGoodStateByGoodIdAndSoState(goodIdC,soleOrder.getSoState());
        //生成订单完成日期
        Date dateType=new Date();
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateType);
        Timestamp soTimeEnd=Timestamp.valueOf(current);
        soleOrder.setSoTimeEnd(soTimeEnd);
        System.out.println(userIdC);
        System.out.println("订单状态"+soleOrder.getSoState());

        //2.更新卖出单
        saleOrderMapper.updSaleOrderStateForFinish(soleOrder,userIdC);
        //3添加买入单
        purchaseOrderMapper.addPurchaseBySoleOrder(soleOrder,userIdC,goodIdC,outUserIdC);
        return true;
    }

    @Override
    public boolean updSaleOrderStateByOrderId(String orderId) {
        int orderIdC = Integer.parseInt(orderId);
        return saleOrderMapper.updSaleOrderStateByOrderId(orderIdC);
    }
}
