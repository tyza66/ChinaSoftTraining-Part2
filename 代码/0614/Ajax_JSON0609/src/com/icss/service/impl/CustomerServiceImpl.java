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
    public boolean deleteSelectedByIds(String[] ids) {
//        涉及事务处理  jdbc自动提交  需要设置不自动提交
        Connection connection = DBUtil.getConnection();
        boolean flag = true;
        try {
            //设置不自动提交
            connection.setAutoCommit(false);


            for (String id : ids) {
                flag = customerDao.deleteCusBySelectedId(connection,Integer.parseInt(id));

                if (!flag) {
                    connection.rollback();//回滚处理
                    return false;
                }
            }

            if (flag) {//数据正常删除
                connection.commit();//提交
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return flag;
    }

    @Override
    public int getCusCount() {
        return customerDao.getCusCount();
    }

    @Override
    public List<Customer> selectCusByPage(int start, int end) {
        return customerDao.selectCusByPage(start,end);
    }

    @Override
    public List<Customer> selectCusByNameAndAge(String cname, String cage, int start, int end) {
        return customerDao.selectCusByNameAndAge(cname,cage,start,end);
    }

    @Override
    public int getCusByNameAndAgeCount(String cname, String cage) {
        return customerDao.getCusByNameAndAgeCount(cname,cage);
    }

}
