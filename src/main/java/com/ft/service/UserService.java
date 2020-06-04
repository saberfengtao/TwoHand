package com.ft.service;

import com.ft.entity.User;

import java.util.List;

public interface UserService {

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
    boolean updUserState(String userId,String userState);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User userLogin(User user);

    /**
     * 邮箱和用户判重
     * @param userMail
     * @return
     */
    boolean getMailFindUser(String userMail);

    boolean haveUserLoginName(String haveUserLoginName);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean userRegister(User user);

    /**
     * 通过用户id修改用户
     * @param user
     * @return
     */
    boolean updUserPassByUserId(User user);

    /**
     * 通过用户id修改用户
     * @param user
     * @return
     */
    boolean updUserMessageByUserId(User user);

    User getUserByUserLoginName(String userId);

}
