package com.sdm;

import com.sdm.config.SpringConfiguration;
import com.sdm.dao.impl.AccountDaoImpl;
import com.sdm.pojo.Account;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    @Test
    public void test3(){
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
        AccountDaoImpl accountDao = context.getBean("accountDao", AccountDaoImpl.class);
        System.out.println("修改返回值"+accountDao.updateAccount(new Account(1001,"tom","96")));
    }

    @Test
    public void test4(){
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
        AccountDaoImpl accountDao = context.getBean("accountDao", AccountDaoImpl.class);
        System.out.println("查找返回值"+accountDao.selectAllAccount());
    }

    @Test
    public void test5(){
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
        AccountDaoImpl accountDao = context.getBean("accountDao", AccountDaoImpl.class);
        System.out.println("ID查找返回值"+accountDao.selectAccountByID(1001));
    }

    @Test
    public void test6(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountDaoImpl accountDao = annotationConfigApplicationContext.getBean("accountDaoImpl", AccountDaoImpl.class);
        System.out.println(accountDao.selectAccountByID(1001));
    }
}
