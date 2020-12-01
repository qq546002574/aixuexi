package com.example.demo.entity;

public class RoleEntity {
    private Integer roleId;
    private Integer userId;
    private String account;
    private Integer deptId;
    private Integer roleType;
    private Integer deptType;
    private String username;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                ", account='" + account + '\'' +
                ", deptId=" + deptId +
                ", roleType=" + roleType +
                ", deptType=" + deptType +
                ", username='" + username + '\'' +
                '}';
    }
}
