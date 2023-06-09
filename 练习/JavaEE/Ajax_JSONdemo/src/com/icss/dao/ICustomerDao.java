package com.icss.dao;

import com.icss.pojo.Customer;

import java.sql.Connection;
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

//    查询访问次数
    int getCount();

//    更新访问次数
    boolean updateCount(int count);

    boolean deleteCusById(Connection connection, int cid);

    int getCueCount();

    List<Customer> selectCuesByPage(int start, int end);

    //    多条件查找并且分页处理
    List<Customer> selectCusByNameAndAge(String cname,String cage,int start,int end);

    //   按照条件返回记录记录数
    int getCusByNameAndAgeCount(String cname,String cage);


}
