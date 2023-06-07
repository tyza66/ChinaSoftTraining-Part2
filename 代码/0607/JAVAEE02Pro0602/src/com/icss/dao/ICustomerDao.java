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

//    根据用户编号进行查询
    Customer selectCusById(int cid);

//    根据用户编号修改
    boolean updateCusById(Customer customer);

}
