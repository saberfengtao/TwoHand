package com.ft.entity;

import java.util.List;

public class Admin {

    private Integer adminId;
    private String adminLoginName;
    private String adminLoginPwd;
    private String adminName;
    private int adminState;
    private List<Role> roleList;

    public Integer getAdminId() {
        return adminId;
    }
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    public String getAdminLoginName() {
        return adminLoginName;
    }
    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName;
    }
    public String getAdminLoginPwd() {
        return adminLoginPwd;
    }
    public void setAdminLoginPwd(String adminLoginPwd) {
        this.adminLoginPwd = adminLoginPwd;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public int getAdminState() {
        return adminState;
    }
    public void setAdminState(int adminState) {
        this.adminState = adminState;
    }
    public List<Role> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminLoginName='" + adminLoginName + '\'' +
                ", adminLoginPwd='" + adminLoginPwd + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminState=" + adminState +
                ", roleList=" + roleList +
                '}';
    }
}
