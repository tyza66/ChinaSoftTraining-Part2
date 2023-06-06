package com.sdm.service;

import com.sdm.pojo.Customer;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/5 11:19
 * Github: https://github.com/tyza66
 **/

public interface ICustomService {
    //根据用户名和密码查询用户
    Customer selectCusByNameAndPwd(String cname, String cpwd);

    Boolean insertOne(Customer customer);

    List<Customer> getAll();

    Boolean updateOne(Customer customer);

    Boolean deleteOne(int id);
}
