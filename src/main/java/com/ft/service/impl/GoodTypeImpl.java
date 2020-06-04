package com.ft.service.impl;

import com.ft.entity.GoodType;
import com.ft.mapper.GoodTypeMapper;
import com.ft.service.GoodTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodTypeImpl implements GoodTypeService {

    @Resource
    GoodTypeMapper goodTypeMapper;

    @Override
    public List<GoodType> getAllGoodTypes() {

        return goodTypeMapper.getAllGoodTypes();
    }

    @Override
    public boolean addGoodType(String goodTypeName) {

        return goodTypeMapper.addGoodType(goodTypeName)<=0 ? false : true;
    }

    @Override
    public boolean delGoodType(String goodTypeId) {
        int goodTypeIdC = Integer.parseInt(goodTypeId);
        return goodTypeMapper.delGoodType(goodTypeIdC)<=0 ? false : true;
    }
}
