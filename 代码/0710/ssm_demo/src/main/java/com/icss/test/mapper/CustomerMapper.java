package com.icss.test.mapper;

import com.icss.test.pojo.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

    Customer selectCusByNameAndPwd(@Param("cname") String cname, @Param("cpwd") String cpwd);

//    如果在注册中要求用户名不能重复
//    1 根据用户名查询
    Customer selectCusByName(String cname);
//    2 如果用户名不重复 则增加
    boolean insertCus(Customer customer);
}
