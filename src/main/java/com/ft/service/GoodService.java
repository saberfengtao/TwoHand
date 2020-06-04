package com.ft.service;

import com.ft.entity.Good;

import java.util.List;

public interface GoodService {

    /**
     * 管理员添加二手物品信息并生成买货单
     * @return
     */
    boolean addGoodFromAdmin(Good good,String goodTypeId,String adminId);


//------------------------下面是用户对物品的操作---------------------------------------------------->

    /**
     * 用户添加二手物品信息并生成买货单
     * @return
     */
    boolean addGoodFromUser(Good good,String goodTypeId,String userId);

    /**
     * 用户修改二手物品信息并生成买货单
     * @return
     */
    boolean updGoodFromUser(Good good,String goodTypeId);

    /**
     *得到所有的物品
     * @return
     */
    List<Good> getAllGood();


    /**
     * 通过物品的ID获取售卖者的信息
     * @param goodId
     * @return
     */
    Good getSaleUserMessageByGoodId(String goodId);

    /**
     * 通过物品的ID获取售卖者的信息
     * @param goodId
     * @return
     */
    Good getGoodByGoodId(String goodId);


    /**
     * 查询所有物品
     * @return
     */
    List<Good> getAllGoods();

    /**
     * 通过物品类型id查询物品
     * @param goodTypeId
     * @return
     */
    List<Good> getAllGoodsByGoodTypeId(String goodTypeId);

    /**
     * 通过用户ID得到上架后未卖出的商品
     * @param userId
     * @return
     */
    List<Good> getSaleGoodByUserId(String userId);

    /**
     * 删除物品和买货单通过物品id
     * @param goodId
     * @return
     */
    boolean delGoodAndSaleOrderByGoodId(String goodId);

    List<Good> getSaleOrderByUserId(String userId);


    /**
     * 通过名字片段进行模糊查询
     * @param goodNameX
     * @return
     */
    List<Good> goodListByGoodNameX(String goodNameX);


    String updGoodStateByMl(String ml);


}
