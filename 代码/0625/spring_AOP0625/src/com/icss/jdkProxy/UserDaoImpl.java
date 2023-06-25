package com.icss.jdkProxy;

/**
 * 业务代码
 */
public class UserDaoImpl implements IUserDao{
    @Override
    public void addUser() {
//        System.out.println("开始执行....");
        System.out.println("增加员工信息");
//        System.out.println("结束执行....");
    }

    @Override
    public void deleteUser() {
//        System.out.println("开始执行....");
        System.out.println("删除员工信息");
//        System.out.println("结束执行....");
    }
}
