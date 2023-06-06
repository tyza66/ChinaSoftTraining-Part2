package com.sdm.service.impl;

import com.sdm.dao.ICustomerDao;
import com.sdm.dao.impl.BaseDao;
import com.sdm.dao.impl.CustomerDaoImpl;
import com.sdm.pojo.Customer;
import com.sdm.service.ICustomService;
import com.sdm.util.DBUtil;

import java.util.List;
import java.util.Objects;

/**
 * Author: tyza66
 * Date: 2023/6/5 11:19
 * Github: https://github.com/tyza66
 **/

public class CustomerServiceImpl implements ICustomService {

    ICustomerDao customerDao= new CustomerDaoImpl();
    BaseDao bd = new BaseDao();

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
        return customerDao.selectCusByNameAndPwd(cname,cpwd);
    }

    @Override
    public Boolean insertOne(Customer customer) {
        return customerDao.insertCus(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Boolean updateOne(Customer customer) {
        return customerDao.updateCus(customer);
    }

    @Override
    public Boolean deleteOne(int id) {
        return customerDao.deleteCus(id);
    }

    @Override
    public List<Customer> selectCusByTwo(String username, String age) {
        List<Customer> query = bd.query("select * from \"customer\" where \"cname\"= ? and \"cage\"= ?", Objects.requireNonNull(DBUtil.getConnection()), username, age);
        return query;
    }


}
