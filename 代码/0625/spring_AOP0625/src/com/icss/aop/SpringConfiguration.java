package com.icss.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //配置类
@ComponentScan("com.icss") //扫描包
@EnableAspectJAutoProxy //开启自动代理模式
public class SpringConfiguration {
}
