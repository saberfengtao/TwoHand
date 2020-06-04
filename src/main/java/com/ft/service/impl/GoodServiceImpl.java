package com.ft.service.impl;

import com.ft.entity.Good;
import com.ft.mapper.GoodMapper;
import com.ft.mapper.SaleOrderMapper;
import com.ft.service.GoodService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service

public class GoodServiceImpl implements GoodService {

    @Resource
    GoodMapper goodMapper;

    @Resource
    SaleOrderMapper saleOrderMapper;

    /**
     * 管理员发布二手信息，并生成买货单
     * @param good
     * @param goodTypeId
     * @param adminId
     * @return
     */
    @Override
    public boolean addGoodFromAdmin(Good good, String goodTypeId, String adminId) {
        //数据类型转换
        int goodTypeIdC = Integer.parseInt(goodTypeId);
        int adminIdC = Integer.parseInt(adminId);
        //添加二手物品信息   ==1  为添加成功
       if(goodMapper.addGoodFromAdmin(good,goodTypeIdC)==1){
           //通过图片路径查询出物品ID,并添加到传来的good中
           good.setGoodId(goodMapper.findNewGoodByGoodPhotoFromAdmin(good.getGoodPhoto()));
           System.out.println("查看重数据库中查到的新的物品ID"+good.getGoodId());
           //获得当前时间生成订单时间
           Date dateType=new Date();
           String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateType);
           Timestamp soTimeStart=Timestamp.valueOf(current);
           //通过照片名字查询物品id
           saleOrderMapper.addSaleOrderFromAdmin(good,soTimeStart,adminIdC);
               //添加成功
           return true;
        }else {
        //生成物品的卖货单（管理员发布的单子）
           //saleOrderMapper.addGoodFromAdmin(good,goodTypeIdC,adminIdC);
           return false;
       }
    }

    @Override
    public boolean addGoodFromUser(Good good, String goodTypeId, String userId) {
        //数据类型转换
        int goodTypeIdC = Integer.parseInt(goodTypeId);
        int userIdC = Integer.parseInt(userId);

        //添加二手物品信息   ==1  为添加成功
        if(goodMapper.addGoodFromUser(good,goodTypeIdC)==1){
            //通过图片路径查询出物品ID,并添加到传来的good中
            good.setGoodId(goodMapper.findNewGoodByGoodPhotoFromUser(good.getGoodPhoto()));
            Date dateType=new Date();
            String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateType);
            Timestamp soTimeStart=Timestamp.valueOf(current);
            //通过照片名字查询物品id
            saleOrderMapper.addSaleOrderFromUser(good,soTimeStart,userIdC);
            //添加成功
            return true;
        }else {
            //生成物品的卖货单（管理员发布的单子）
            //saleOrderMapper.addGoodFromAdmin(good,goodTypeIdC,adminIdC);
            return false;
        }
    }

    @Override
    public boolean updGoodFromUser(Good good, String goodTypeId) {
        //数据类型转换
        int goodTypeIdC = Integer.parseInt(goodTypeId);
        if(goodMapper.updGoodFromUser(good,goodTypeIdC)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Good> getAllGood() {
        return goodMapper.getAllGood();
    }

    @Override
    public Good getSaleUserMessageByGoodId(String goodId) {
        return null;
    }

    @Override
    public Good getGoodByGoodId(String goodId) {
        int goodIdC = Integer.parseInt(goodId);
        return goodMapper.getGoodByGoodId(goodIdC);
    }

    @Override
    public List<Good> getAllGoods() {
        return null;
    }

    @Override
    public List<Good> getAllGoodsByGoodTypeId(String goodTypeId) {
        int goodTypeIdC = Integer.parseInt(goodTypeId);

        return  goodMapper.getAllGoodsByGoodTypeId(goodTypeIdC);
    }

    @Override
    public List<Good> getSaleGoodByUserId(String userId) {
        int userIdC = Integer.parseInt(userId);
        return goodMapper.getSaleGoodByUserId(userIdC);
    }

    @Override
    public boolean delGoodAndSaleOrderByGoodId(String goodId) {
        int goodIdC = Integer.parseInt(goodId);
        if (goodMapper.deleteGoodByGoodId(goodIdC)==1){
            saleOrderMapper.deleteSaleOrderByGoodId(goodIdC);
            return true;
        }
        return false;
    }

    @Override
    public List<Good> getSaleOrderByUserId(String userId) {
        return null;
    }

    @Override
    public List<Good> goodListByGoodNameX(String goodNameX) {
        return goodMapper.goodListByGoodNameX(goodNameX);
    }

    @Override
    public String updGoodStateByMl(String ml) {
          int goodState;
        if (ml.equals("userSj")){

             goodState=0;
        }else if (ml.equals("userXj")){
             goodState=20;
        }else if (ml.equals("adminXj")){

             goodState=23;
        }else if (ml.equals("adminSj")){
             goodState=3;
        }else{
            return "error";
        }
        if(goodMapper.updGoodStateByMl(goodState)>0){
            return null;
        }else {
        return "error";}
    }
}
