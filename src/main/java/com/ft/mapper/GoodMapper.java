package com.ft.mapper;

import com.ft.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodMapper {

    /**
     * 添加物品，和物品类型的id（admin）
     * @param good
     * @param goodTypeId
     * @return
     */
    int addGoodFromAdmin(@Param("good")Good good, @Param("goodTypeId")int goodTypeId);

    /**
     * 添加物品，和物品类型的id（user）
     * @param good
     * @param goodTypeId
     * @return
     */
    int addGoodFromUser(@Param("good")Good good, @Param("goodTypeId")int goodTypeId);

    /**
     * 修改物品，和物品类型的id（user）
     * @param good
     * @param goodTypeId
     * @return
     */
    int updGoodFromUser(@Param("good")Good good, @Param("goodTypeId")int goodTypeId);



    /**
     * 通过图片名查询新添加的物品ID（admin）
     * @param goodPhoto
     * @return
     */
    int findNewGoodByGoodPhotoFromAdmin(String goodPhoto);



    /**
     * 通过图片名查询新添加的物品ID（user）
     * @param goodPhoto
     * @return
     */
    int findNewGoodByGoodPhotoFromUser(String goodPhoto);


    /**
     * 通过用户id查询物品
     * @param userId
     * @return
     */
    List<Good> getSaleGoodByUserId(int userId);

    /**
     * 通过物品类型id查询所有物品
     * @param goodTypeId
     * @return
     */
    List<Good> getAllGoodsByGoodTypeId(int goodTypeId);

    /**
     * 通过货物ID查询货品
     * @param goodId
     * @return
     */
    Good getGoodByGoodId(int goodId);

    /**
     *得到所有的物品
     * @return
     */
    List<Good> getAllGood();

    /**
     * 通过物品ID和传来的订单状态修改物品状态
     * @param goodId
     * @param soState
     * @return
     */
    int updGoodStateByGoodIdAndSoState(int goodId,int soState);

    /**
     * 通过名字片段进行模糊查询
     * @param goodNameX
     * @return
     */
    List<Good> goodListByGoodNameX(String goodNameX);


    int updGoodStateByMl(int goodState);

    int deleteGoodByGoodId(int goodId);

}
