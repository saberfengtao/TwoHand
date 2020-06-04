package com.ft.service;

import com.ft.entity.Admin;
import com.ft.entity.Authority;


import java.util.List;

public interface AdminService {
    /**
     * 根据用户名获取用户信息
     * @param adminLoginName
     * @return
     */
    Admin getAdminByLoginName(String adminLoginName);

    /**
     * 获得该用户的所有权限
     * @param adminName
     * @return
     */
    List<Authority> getAuthoritiesByAdminName(String adminName);

    /**
     * 判断管理注册的管理员账号是否重复
     * @param adminLoginName
     * @return
     */
    boolean findAdminByName(String adminLoginName);

    /**
     * 判断管理注册的管理员账号是否重复
     * @param adminRole
     * @return
     */
    boolean findRoleByName(String adminRole);

    /**
     * 通过用户id修改用户
     * @param admin
     * @return
     */
    boolean updUserByAdminId(Admin admin);

    /**
     * 添加角色
     * @param admin
     * @param roleId
     * @return
     */
    int addUser(Admin admin,String[] roleId);

    /**
     * 查询所有用户
     * @return
     */
    List<Admin> getAllUsers();

    /**
     * 根据管理员id获得管理员
     * @param adminId
     * @return
     */
    Admin getAdminByAdminId(int adminId);

    /**
     * 更改用管理员（其他）
     * @param admin
     * @param autho
     */
    void updRole(Admin admin,String[] autho);

}
