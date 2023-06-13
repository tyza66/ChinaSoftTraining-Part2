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

    boolean DeleteCusByIds(String[] ids);

}
