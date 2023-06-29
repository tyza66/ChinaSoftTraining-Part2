package com.icss.mapper;

import com.icss.pojo.Users;

public interface UsersMapper {
//    一个用户可以有多个角色  一对多
    Users selectUserAndRoles(String uname);

}
