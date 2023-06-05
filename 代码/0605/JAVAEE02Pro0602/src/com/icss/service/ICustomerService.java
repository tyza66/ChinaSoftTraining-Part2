package com.icss.service;

import com.icss.pojo.Customer;

public interface ICustomerService {
    Customer selectCusByNameAndPwd(String cname, String cpwd);
}
