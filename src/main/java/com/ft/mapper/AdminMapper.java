package com.ft.mapper;

import com.ft.entity.Admin;
import com.ft.entity.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     * 根据管理员名获取用户信息
     * @param adminLoginName
     * @return
     */
    Admin getAdminByLoginName(String adminLoginName);

    /**
     * 获得该管理员的所有权限
     * @param adminLoginName
     * @return
     */
    List<Authority> getAuthoritiesByAdminName(String adminLoginName);

    /**
     * 对注册的管理员查重
     * @param adminLoginName
     * @return
     */
    int findAdminByName(String adminLoginName);

    /**
     * 对注册的角色查重
     * @param adminRole
     * @return
     */
    int findRoleByName(String adminRole);

    /**
     * 添加管理员和相关角色
     * @param admin
     * @return
     */
    int addAdmin(Admin admin);

    /**
     * 添加用户角色
     * @return
     */
    int addAdminRole(@Param("adminLoginName") String adminLoginName, @Param("roles")String[] roles);

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    int updUserByAdminId(Admin admin);

    /**
     *修改管理员信息(超级管理员)
     * @param admin
     * @return
     */
    int updUserByAdminIdM(Admin admin);

    /**
     * 通过用户ID删除角色
     * @param adminId
     * @return
     */
    int delAdminRole(String adminId);

    /**
     * 得到所有用户
     * @return List<Role>
     */
    List<Admin> getAllUsers();

    /**
     * 根据管理员id获得管理员
     * @param adminId
     * @return
     */
    Admin getAdminByAdminId(int adminId);
}



