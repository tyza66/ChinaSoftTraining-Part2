package com.icss.test.pojo;

import java.io.Serializable;

public class Role implements Serializable {

    //    生成一个序列号
    private static final long serialVersionUID = 4922600578281268146L;

    private Integer roleid;
    private String rolename;

    public Role() {
    }

    public Role(Integer roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
