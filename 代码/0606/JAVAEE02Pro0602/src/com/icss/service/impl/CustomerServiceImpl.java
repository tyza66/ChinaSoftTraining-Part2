package com.icss.service.impl;

import com.icss.dao.impl.CustomerDaoImpl;
import com.icss.pojo.Customer;
import com.icss.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
        return customerDao.selectCusByNameAndPwd(cname,cpwd);
    }

    @Override
    public boolean registerCustomer(Customer customer) {
//        要求用户名不能重复 如果重复则注册失败 不重复增加用户信息
        if (customerDao.selectCusByCname(customer.getCname()) == null) {
            return customerDao.insertCus(customer);
        } else {
            return false;
        }
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerDao.selectAllCustomer();
    }

    @Override
    public boolean deleteCusById(int cid) {
        return customerDao.deleteCusById(cid);
    }
}
