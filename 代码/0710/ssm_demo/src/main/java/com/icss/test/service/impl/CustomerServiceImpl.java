package com.icss.test.service.impl;

import com.icss.test.mapper.CustomerMapper;
import com.icss.test.pojo.Customer;
import com.icss.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
        return customerMapper.selectCusByNameAndPwd(cname,cpwd);
    }

    @Override
    public boolean registerCus(Customer customer) {
        Customer customer1 = customerMapper.selectCusByName(customer.getCname());
        if (customer1 == null) {
            return customerMapper.insertCus(customer);
        } else {
            return false;
        }
    }
}
