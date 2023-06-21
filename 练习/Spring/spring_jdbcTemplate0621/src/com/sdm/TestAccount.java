package com.sdm;

import com.sdm.dao.impl.AccountDaoImpl;
import com.sdm.pojo.Account;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: tyza66
 * Date: 2023/6/21 9:48
 * Github: https://github.com/tyza66
 **/

public class TestAccount {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
        Account account = context.getBean("account", Account.class);
        System.out.println(account);
        Account account2 = context.getBean("account", Account.class);
        System.out.println(account2==account);
        context.close();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
        AccountDaoImpl accountDao = context.getBean("accountDao", AccountDaoImpl.class);
        System.out.println("插入返回值"+accountDao.insertAccount(new Account(1001,"tom","2000")));
    }
}
