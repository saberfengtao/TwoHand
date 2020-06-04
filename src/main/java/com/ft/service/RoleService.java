package com.ft.service;

import com.ft.entity.Role;

import java.util.List;

public interface RoleService {

    boolean addRole(String roleName);

    boolean addRoleAuthority(String roleName,String[] authority);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> getAllRoles();

    Role getRoleById(int id);

    void updRole(Role role,String[] autho);

    void delRole(int roleId);

}
