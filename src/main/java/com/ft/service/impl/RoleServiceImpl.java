package com.ft.service.impl;

import com.ft.entity.Authority;
import com.ft.entity.Role;
import com.ft.exceprion.CustomException;
import com.ft.mapper.RoleMapper;
import com.ft.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public boolean addRole(String roleName) {
        return roleMapper.addRole(roleName);
    }

    @Override
    public boolean addRoleAuthority(String roleName, String[] authority) {

        if (authority==null){
            return true;
        }
        int id=roleMapper.getRoleIdByName(roleName);
        return roleMapper.addRoleAuthority(id,authority);
    }

    //查询所有角色
    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    //查询选择角色的权限
    @Override
    public Role getRoleById(int id) {
        Role role = roleMapper.getRoleById(id);
        List<Authority> authorities = roleMapper.getAuthoritiesByRoleId(id);
        role.setAuthorityList(authorities);
        return role;
    }

    @Override
    public void updRole(Role role, String[] authority) {
        /*修改后的角色名称不能与其他角色名重名，因此在这里需要进行验证*/
        Integer id = roleMapper.getRoleIdByName(role.getRoleName());
        //String  name= roleMapper
        //根据角色名称查询角色id后如果这个id不为空并且不与当前角色id一致则表示有其他角色名与修改后的角色名冲突

        if(id != null && id.intValue()!=role.getRoleId()) {
            throw new CustomException(2000,"该角色已经存在");
        }

     //判断修改后权限是否为空
        if (authority==null){
            //修改角色名和状态
            roleMapper.updRole(role);
            //删除该角色的所有权限
            roleMapper.delRoleAutho(role.getRoleId());
        }else{
            //修改角色名和状态
            roleMapper.updRole(role);
            //删除该角色的所有权限
            roleMapper.delRoleAutho(role.getRoleId());
            //重新添加该角色的所有权限
            roleMapper.addRoleAuthority(role.getRoleId(),authority);}
    }

    @Override
    public void delRole(int roleId) {

    }
}
