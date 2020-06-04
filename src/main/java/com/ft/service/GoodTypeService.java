package com.ft.service;

import com.ft.entity.GoodType;

import java.util.List;

public interface GoodTypeService {

    /**
     * 查询所有物品类型
     * @return
     */
    List<GoodType> getAllGoodTypes();

    /**
     * 添加物品类型
     * @param goodTypeName
     * @return
     */
    boolean addGoodType(String goodTypeName);

    /**
     * 删除物品类型
     * @param goodTypeId
     * @return
     */
    boolean delGoodType(String goodTypeId);
}
