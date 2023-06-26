package com.sdm.test;

import com.sdm.dao.impl.AccountDaoImpl;
import com.sdm.service.AccountService;
import com.sdm.service.impl.AccountServiceImpl;
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

    @org.junit.Test
    public void test2() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
        //这里使用接口承接 因为底层使用的是jdk动态代理
        AccountService accountServiceImpl = context.getBean("accountServiceImpl", AccountService.class);
        //汤姆给jerry100块钱
        boolean transfer = accountServiceImpl.transfer(1001, 1002, 100);
        System.out.println(transfer);
    }
}
