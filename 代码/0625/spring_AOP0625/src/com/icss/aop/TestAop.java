package com.icss.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        UserDao userDao = applicationContext.getBean("target",UserDao.class);

        userDao.addUser();

    }
}
