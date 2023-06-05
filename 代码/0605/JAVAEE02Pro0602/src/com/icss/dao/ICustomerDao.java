package com.icss.dao;

import com.icss.pojo.Customer;

public interface ICustomerDao {
//    根据用户名和密码查询用户
    Customer selectCusByNameAndPwd(String cname,String cpwd);
}
