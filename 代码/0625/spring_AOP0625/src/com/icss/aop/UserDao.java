package com.icss.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Repository;

/**
 * cglib代理 基于类
 * 目标对象
 */
@Repository
public class UserDao {
    public void addUser(){
        System.out.println("增加员工");
        System.out.println(1/0);
    }

    public int deleteUser(){
        System.out.println("删除员工");
        return 2;//返回值
    }

}
