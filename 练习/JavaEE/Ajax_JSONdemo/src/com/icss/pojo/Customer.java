package com.icss.pojo;

/**
 * 用户表对应的实体类  Model层 负责数据的传递
 */
public class Customer {
//    用户编号
    private int cid;
//    用户姓名
    private String cname;
//    用户密码
    private String cpwd;
//    用户年龄
    private String cage;

    public Customer() {
    }

    public Customer(int cid, String cname, String cpwd, String cage) {
        this.cid = cid;
        this.cname = cname;
        this.cpwd = cpwd;
        this.cage = cage;
    }

    public Customer(String cname, String cpwd, String cage) {
        this.cname = cname;
        this.cpwd = cpwd;
        this.cage = cage;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cpwd='" + cpwd + '\'' +
                ", cage=" + cage +
                '}';
    }
}
