package com.icss.service;

import com.icss.pojo.Customer;

import java.util.List;

public interface ICustomerService {
    Customer selectCusByNameAndPwd(String cname, String cpwd);
//    注册
    boolean registerCustomer(Customer customer);

    List<Customer> selectAllCustomer();

    boolean deleteCusById(int cid);

    Customer selectCusById(int cid);

    boolean updateCusById(Customer customer);


    //    查询访问次数
    int getCount();

    //    更新访问次数
    boolean updateCount(int count);

    boolean deleteSelectedByIds(String[] ids);


    //    查询用户表总的记录数
    int getCusCount();

    //    每页显示的数据
    List<Customer> selectCusByPage(int start,int end);

}
