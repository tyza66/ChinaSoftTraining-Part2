package com.icss.pojo;

import java.util.List;

/**
 * 用户表
 * 一个用户可以有多个角色  一对多
 */
public class Users {
    private int uid;
    private String uname;
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Users() {
    }

    public Users(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
