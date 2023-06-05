package com.sdm.pojo;

/**
 * Author: tyza66
 * Date: 2023/6/5 10:42
 * Github: https://github.com/tyza66
 **/

public class Customer {
    private Integer id;
    private String cname;
    private String cpwd;
    private String cage;

    public Customer() {
    }

    public Customer(Integer id, String cname, String cpwd, String cage) {
        this.id = id;
        this.cname = cname;
        this.cpwd = cpwd;
        this.cage = cage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
