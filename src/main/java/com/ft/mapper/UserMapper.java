package com.ft.mapper;

import com.ft.entity.User;

import java.util.List;


public interface UserMapper {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User userLogin(User user);

    /**
     * 根据邮箱号查找用户
     * @param userMail
     * @return
     */
    int  getMailFindUser(String userMail);

    /**
     * 用户名判重
     * @param haveUserLoginName
     * @return
     */
    int  haveUserLoginName(String haveUserLoginName);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int userRegister(User user);


    /**
     * 用户更改密码
     * @param user
     * @return
     */
    int updUserPassByUserId(User user);

    /**
     * 用户更改基本信息
     * @param user
     * @return
     */
    int updUserMessageByUserId(User user);

    /**
     * 通过用户的登录名获得用户
     * @param userId
     * @return
     */
    User getUserByUserLoginName(int userId);

    /**
     * 得到所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 修改用户状态
     * @param userId
     * @param userState
     * @return
     */
    int updUserState(int userId,int userState);

}
