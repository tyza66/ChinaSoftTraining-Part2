package com.icss.pojo;

/**
 * 员工表对应的实体类
 */
public class Emp {
    private int eid;
    private String ename;
    private int esal;
//    部门作为属性  员工所属的部门
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
