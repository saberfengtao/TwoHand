package com.ft.service.impl;

import com.ft.entity.PurchaseOrder;
import com.ft.mapper.PurchaseOrderMapper;
import com.ft.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Resource
    PurchaseOrderMapper purchaseOrderMapper;

    @Override
    public List<PurchaseOrder> getAllPurchaseOrderByUserId(String inUserId) {
        int inUserIdC = Integer.parseInt(inUserId);
        return purchaseOrderMapper.getAllPurchaseOrderByUserId(inUserIdC);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrder() {
        return null;
    }

    @Override
    public boolean updPurchaseOrderStateByOrderStateAndOrderID(String orderState,String orderId) {
        int orderStateC = Integer.parseInt(orderState);
        int orderIdC = Integer.parseInt(orderId);
        return purchaseOrderMapper.updPurchaseOrderStateByOrderStateAndId(orderStateC,orderIdC)<=0 ? false : true;
    }
}
