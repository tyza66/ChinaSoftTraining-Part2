package com.icss.cglibProxy;

/**
 * cglib代理 基于类
 * 目标对象
 */
public class UserDao {
    public void addUser(){
        System.out.println("增加员工");
    }

    public void deleteUser(){
        System.out.println("删除员工");
    }

}
