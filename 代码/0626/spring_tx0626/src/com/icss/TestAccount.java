package com.icss;

import com.icss.service.IAccountService;
import com.icss.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

    @Test
    public void test1(){
//        初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//      基于接口
        IAccountService accountService = applicationContext.getBean("accoutServiceImpl", IAccountService.class);
        boolean flag = accountService.transferAccount("tom","jack",50);
        System.out.println("返回值类型 " + flag);
    }
}
