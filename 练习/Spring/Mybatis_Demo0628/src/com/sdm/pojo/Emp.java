package com.sdm.pojo;

/**
 * Author: tyza66
 * Date: 2023/6/28 12:46
 * Github: https://github.com/tyza66
 **/

public class Emp {
    private int eid;
    private String ename;
    private int esal;
    private Dept dept;

    public Emp() {
    }

    public Emp(int eid, String ename, int esal, Dept dept) {
        this.eid = eid;
        this.ename = ename;
        this.esal = esal;
        this.dept = dept;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEsal() {
        return esal;
    }

    public void setEsal(int esal) {
        this.esal = esal;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esal=" + esal +
                ", dept=" + dept +
                '}';
    }
}
