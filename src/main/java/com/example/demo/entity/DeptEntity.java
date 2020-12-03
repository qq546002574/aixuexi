package com.example.demo.entity;

public class DeptEntity {
    private Integer deptId;
    private Integer deptType;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    @Override
    public String toString() {
        return "DeptEntity{" +
                "deptId=" + deptId +
                ", deptType=" + deptType +
                '}';
    }
}
