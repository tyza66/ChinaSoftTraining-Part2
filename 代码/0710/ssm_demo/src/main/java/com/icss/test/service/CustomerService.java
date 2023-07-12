package com.icss.test.service;

import com.icss.test.pojo.Customer;

public interface CustomerService {

    Customer selectCusByNameAndPwd(String cname,String cpwd);

    boolean registerCus(Customer customer);
}
