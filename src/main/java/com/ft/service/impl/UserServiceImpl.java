package com.ft.service.impl;

import com.ft.entity.User;
import com.ft.mapper.UserMapper;
import com.ft.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public boolean updUserState(String userId, String userState) {
        int userIdC = Integer.parseInt(userId);
        int userStateC = Integer.parseInt(userState);
        return userMapper.updUserState(userIdC,userStateC)<=0 ? false : true;
    }

    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public boolean getMailFindUser(String userMail) {
        return userMapper.getMailFindUser(userMail)<=0 ? true :false ;
    }

    @Override
    public boolean haveUserLoginName(String haveUserLoginName) {
        return userMapper.haveUserLoginName(haveUserLoginName)<=0 ? true :false;
    }

    @Override
    public boolean userRegister(User user) {
        //结果小于等于0证明在数据库中查重是没有找到一样的数据
        if(userMapper.haveUserLoginName(user.getUserLoginName())<=0){

            return userMapper.userRegister(user)<=0? false : true;
        }else{

            return false;
        }
    }

    @Override
    public boolean updUserPassByUserId(User user) {
        return userMapper.updUserPassByUserId(user)<=0 ?  false:true;
    }

    @Override
    public boolean updUserMessageByUserId(User user) {
        return userMapper.updUserMessageByUserId(user)<=0 ? false:true;
    }

    @Override
    public User getUserByUserLoginName(String userId) {
        int userIdC = Integer.parseInt(userId);
        return userMapper.getUserByUserLoginName(userIdC);
    }
}
