package com.ft.mapper;

import com.ft.entity.GoodType;

import java.util.List;

public interface GoodTypeMapper {


    /**
     * 得到所有的物品类型
     * @return
     */
    List<GoodType> getAllGoodTypes();

    /**
     * 添加新的物品类别
     * @param goodTypeName
     * @return
     */
    int addGoodType(String goodTypeName);

    /**
     * 删除物品类型
     * @param goodTypeId
     * @return
     */
    int delGoodType(int goodTypeId);
}
