package com.ft.entity;


import java.util.List;

public class Role {
    private int roleId;
    private String roleName;
    private int roleState;
    private boolean isSelected;
    private List<Authority> authorityList;

    public int getRoleId() {

        return roleId;
    }

    public void setRoleId(int roleId) {

        this.roleId = roleId;
    }

    public String getRoleName() {

        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }

    public List<Authority> getAuthorityList() {

        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {

        this.authorityList = authorityList;
    }

    public int getRoleState() {
        return roleState;
    }

    public void setRoleState(int roleState) {
        this.roleState = roleState;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleState=" + roleState +
                ", isSelected=" + isSelected +
                ", authorityList=" + authorityList +
                '}';
    }
}
