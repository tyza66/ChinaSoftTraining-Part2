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

    //查询用户表的总记录数
    int getCustomerCount();

    //查询显示的数据
    List<Customer> getCustomerListByPage(int start, int end);

    //    多条件查找并且分页处理
    List<Customer> selectCusByNameAndAge(String cname, String cage, int start, int end);

    //   按照条件返回记录记录数
    int getCusByNameAndAgeCount(String cname, String cage);

}
