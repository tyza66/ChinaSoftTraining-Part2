package com.icss.service;

import com.icss.pojo.Customer;

import java.util.List;

public interface ICustomerService {
    Customer selectCusByNameAndPwd(String cname, String cpwd);
//    注册
    boolean registerCustomer(Customer customer);

    List<Customer> selectAllCustomer();

    boolean deleteCusById(int cid);
}
