package com.sdm.service.impl;

import com.sdm.dao.ICustomerDao;
import com.sdm.dao.impl.CustomerDaoImpl;
import com.sdm.pojo.Customer;
import com.sdm.service.ICustomService;

/**
 * Author: tyza66
 * Date: 2023/6/5 11:19
 * Github: https://github.com/tyza66
 **/

public class CustomerServiceImpl implements ICustomService {

    ICustomerDao customerDao= new CustomerDaoImpl();

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
        return customerDao.selectCusByNameAndPwd(cname,cpwd);
    }

    @Override
    public Boolean insertOne(Customer customer) {
        return customerDao.insertCus(customer);
    }
}
