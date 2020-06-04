package com.ft.mapper;

import com.ft.entity.Authority;
import com.ft.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    /**
     * 添加角色
     * @param roleName
     * @return
     */
    boolean addRole(String roleName);

    /**
     * 得到所有角色
     * @return List<Role>
     */
    List<Role> getAllRoles();

    /**
     * 得到所有角色通过管理员ID
     * @return List<Role>
     */
    List<Role> getAllRolesByAdminId(int adminId);

    /**
     * 为角色添加权限
     * @param roleId
     * @param authority
     * @return
     */
    boolean addRoleAuthority(@Param("roleId") int roleId, @Param("authority") String[] authority);

    /**
     * 修改角色
     * @param role
     * @return
     */
    int updRole(Role role);

    /**
     * 通过角色ID删除该角色的所有权限
     * @param roleId
     * @return
     */
    int delRoleAutho(int roleId);

    /**
     * 根据角色名称获取角色的id，角色名必须唯一
     * @param roleName
     * @return
     */
    Integer getRoleIdByName(String roleName);

    /**
     * 根据id查询到角色对象
     * @param id
     * @return
     */
    Role getRoleById(int id);

    List<Authority> getAuthoritiesByRoleId(int id);
}
