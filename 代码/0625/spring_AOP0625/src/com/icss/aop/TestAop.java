package com.icss.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        UserDao userDao = applicationContext.getBean("target",UserDao.class);

        userDao.addUser();

//        userDao.deleteUser();

    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotaion.xml");
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
//        userDao.deleteUser();
        userDao.addUser();
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
//        userDao.deleteUser();
        userDao.addUser();
    }
}
