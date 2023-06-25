package com.icss.cglibProxy;

import org.junit.Test;

public class TestCglibProxy {

    @Test
    public void test1(){
//        获取代理对象
        CglibProxy cglibProxy = new CglibProxy();

//        创建目标对象
        UserDao dao = new UserDao();

        UserDao userDao = (UserDao) cglibProxy.createProxy(dao);

        userDao.addUser();
    }
}
