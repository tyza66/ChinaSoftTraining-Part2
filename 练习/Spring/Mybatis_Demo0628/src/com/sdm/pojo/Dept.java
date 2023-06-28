package com.sdm.pojo;

/**
 * Author: tyza66
 * Date: 2023/6/28 10:44
 * Github: https://github.com/tyza66
 *
 * 属性名和表明中字段不一致的时候 可以手动映射
 **/

public class Dept {
    private int deptId;
    private String deptName;
    private String deptLoc;

    public Dept() {
    }

    public Dept(int deptId, String deptName, String deptLoc) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLoc() {
        return deptLoc;
    }

    public void setDeptLoc(String deptLoc) {
        this.deptLoc = deptLoc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptLoc='" + deptLoc + '\'' +
                '}';
    }
}
