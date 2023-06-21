package com.sdm;

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
    }
}
