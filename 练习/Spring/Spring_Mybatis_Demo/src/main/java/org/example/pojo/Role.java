package org.example.pojo;

import java.io.Serializable;

/**
 * Author: tyza66
 * Date: 2023/6/30 14:14
 * Github: https://github.com/tyza66
 **/

public class Role implements Serializable {
    private Integer roleId;
    private String roleName;

    public Role() {
    }

    public Role(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

}
