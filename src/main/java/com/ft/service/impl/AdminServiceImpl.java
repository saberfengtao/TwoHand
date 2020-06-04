package com.ft.service.impl;

import com.ft.entity.Admin;
import com.ft.entity.Authority;
import com.ft.entity.Role;
import com.ft.mapper.AdminMapper;
import com.ft.mapper.RoleMapper;
import com.ft.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Resource
    RoleMapper roleMapper;


    @Override
    public Admin getAdminByLoginName(String adminLoginName) {
        return adminMapper.getAdminByLoginName(adminLoginName);
    }

    @Override
    public List<Authority> getAuthoritiesByAdminName(String adminName) {
        return adminMapper.getAuthoritiesByAdminName(adminName);
    }

    @Override
    public boolean findAdminByName(String adminLoginName) {
        return adminMapper.findAdminByName(adminLoginName)<=0 ? true : false;
    }

    @Override
    public boolean findRoleByName(String adminRole) {
        return adminMapper.findRoleByName(adminRole)<=0 ? true : false;
    }

    @Override
    public boolean updUserByAdminId(Admin admin) {
        return adminMapper.updUserByAdminId(admin)<=0 ? false : true;
    }

    /**
     * 添加用户和角色
     * @param admin
     * @param roleId
     * @return
     */
    @Override
    public int addUser(Admin admin, String[] roleId) {
        if(roleId==null){
            return adminMapper.addAdmin(admin);
        }
        else {
        adminMapper.addAdmin(admin);
        System.out.println("传来的数字"+roleId);
        return adminMapper.addAdminRole(admin.getAdminLoginName(),roleId);}
    }

    @Override
    public List<Admin> getAllUsers() {
        return adminMapper.getAllUsers();
    }

    //修改用户提前获得要修改的数据
    @Override
    public Admin getAdminByAdminId(int adminId) {
        Admin admin = adminMapper.getAdminByAdminId(adminId);
        List<Role> roles=roleMapper.getAllRolesByAdminId(adminId);
        admin.setRoleList(roles);
        return admin;
    }

    @Override
    public void updRole(Admin admin, String[] roles) {
        if(roles==null){
            //更改管理员
            adminMapper.updUserByAdminIdM(admin);
            //删除该用户所有角色
            adminMapper.delAdminRole(admin.getAdminLoginName());
        }else {

            //更改管理员
            adminMapper.updUserByAdminIdM(admin);
            //删除该用户所有角色
            adminMapper.delAdminRole(admin.getAdminLoginName());
            //为用户添加角色
            adminMapper.addAdminRole(admin.getAdminLoginName(),roles);
        }


    }


}
