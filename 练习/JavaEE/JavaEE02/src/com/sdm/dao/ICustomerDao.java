package com.sdm.dao;

import com.sdm.pojo.Customer;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/5 10:57
 * Github: https://github.com/tyza66
 **/

public interface ICustomerDao {
    //根据用户名和密码查询用户
    Customer selectCusByNameAndPwd(String cname, String cpwd);

    Boolean insertCus(Customer customer);

    List<Customer> getAll();

    Boolean updateCus(Customer customer);

    Boolean deleteCus(int id);
}
