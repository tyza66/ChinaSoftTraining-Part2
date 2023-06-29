package com.icss.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 属性名称和表中字段名称一致 完成自动映射 resultType
 * 如果属性名称和表中字段名称不一致
 * 1 列 别名 和 属性名称一致
 * 2 手动映射的结果集 resultMap
 *
 */
public class Dept implements Serializable {

    private int deptid;
    private String deptname;
    private String deptloc;
//    一个部门多个员工
    private List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public Dept() {
    }

    public Dept(int deptid, String deptname, String deptloc) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptloc = deptloc;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptloc() {
        return deptloc;
    }

    public void setDeptloc(String deptloc) {
        this.deptloc = deptloc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", deptloc='" + deptloc + '\'' +
                ", empList=" + empList +
                '}';
    }
}
