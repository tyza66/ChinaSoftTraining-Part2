package com.icss.service.impl;

import com.icss.dao.impl.CustomerDaoImpl;
import com.icss.pojo.Customer;
import com.icss.service.ICustomerService;
import com.icss.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    CustomerDaoImpl customerDao = new CustomerDaoImpl();

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
        return customerDao.selectCusByNameAndPwd(cname, cpwd);
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

    @Override
    public Customer selectCusById(int cid) {
        return customerDao.selectCusById(cid);
    }

    @Override
    public boolean updateCusById(Customer customer) {
        return customerDao.updateCusById(customer);
    }

    @Override
    public int getCount() {
        return customerDao.getCount();
    }

    @Override
    public boolean updateCount(int count) {
        return customerDao.updateCount(count);
    }

    @Override
    public boolean DeleteCusByIds(String[] ids) {
        Connection connection = DBUtil.getConnection();
        //设计事物处理
        boolean flag = true;
        try {
            connection.setAutoCommit(false);
            for (String id : ids) {
                flag = customerDao.deleteCusById(Integer.parseInt(id));
                if (!flag) {
                    connection.rollback();
                }
            }
            if (flag) {
                connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return flag;
    }

    @Override
    public int getCustomerCount() {
        return 0;
    }

    @Override
    public List<Customer> getCustomerList(int start, int end) {
        return null;
    }
}
