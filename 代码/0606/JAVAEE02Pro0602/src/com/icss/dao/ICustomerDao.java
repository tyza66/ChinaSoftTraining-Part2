package com.icss.dao;

import com.icss.pojo.Customer;

import java.util.List;

public interface ICustomerDao {
//    根据用户名和密码查询用户
    Customer selectCusByNameAndPwd(String cname,String cpwd);
//    根据用户名查询
    Customer selectCusByCname(String cname);
//    插入用户
    boolean insertCus(Customer cus);
//    查询所有的用户
    List<Customer> selectAllCustomer();

//    按照用户编号删除
    boolean deleteCusById(int cid);

}
