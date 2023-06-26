package com.sdm.test;

import com.sdm.dao.impl.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:48
 * Github: https://github.com/tyza66
 **/

public class Test {


    @org.junit.Test
    public void test1() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
        AccountDaoImpl accountDao = context.getBean("accountDaoImpl", AccountDaoImpl.class);
        boolean b = accountDao.addMoney("1001", 200);
        System.out.println(b);
        boolean b1 = accountDao.reduceMoney("1002", 4);
        System.out.println(b1);
    }
}
