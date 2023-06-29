package com.icss.mapper;

import com.icss.pojo.Role;

public interface RoleMapper {
    Role selectRoleAndUsers(String rolename);
}
