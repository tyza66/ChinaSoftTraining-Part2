package com.icss.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// @Configuration 配置类    @ComponentScan("com.icss") 扫描包  @Import(JDBConfig.class) 引入JDBConfig配置类
@Configuration
@ComponentScan("com.icss")
@Import(JDBConfig.class)
public class SpringConfiguration {
}
