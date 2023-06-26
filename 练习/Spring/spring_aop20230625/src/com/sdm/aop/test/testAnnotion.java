package com.sdm.aop.test;

import com.sdm.aop.config.SpringConfiguration;
import com.sdm.aop.testannotion.Target1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: tyza66
 * Date: 2023/6/26 8:57
 * Github: https://github.com/tyza66
 **/

public class testAnnotion {
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotion.xml");

        Target1 target1 = applicationContext.getBean("target1", Target1.class);

        target1.giao1();
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Target1 target1 = applicationContext.getBean("target1", Target1.class);
        target1.giao1();
    }
}
