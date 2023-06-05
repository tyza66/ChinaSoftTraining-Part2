package com.icss.service.impl;

import com.icss.dao.impl.CustomerDaoImpl;
import com.icss.pojo.Customer;
import com.icss.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
        return customerDao.selectCusByNameAndPwd(cname,cpwd);
    }
}
