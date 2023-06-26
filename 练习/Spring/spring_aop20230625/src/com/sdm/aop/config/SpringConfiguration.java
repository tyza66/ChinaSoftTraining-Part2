package com.sdm.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author: tyza66
 * Date: 2023/6/26 8:59
 * Github: https://github.com/tyza66
 **/

@Configuration //配置类
@ComponentScan("com.sdm") //扫描包
@EnableAspectJAutoProxy //开启自动代理模式
public class SpringConfiguration {
}
