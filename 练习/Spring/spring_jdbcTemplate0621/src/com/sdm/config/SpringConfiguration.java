package com.sdm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author: tyza66
 * Date: 2023/6/21 13:00
 * Github: https://github.com/tyza66
 **/
//@Configuration配置类
@Configuration
@ComponentScan("com.sdm")
@Import(JDBCConfig.class)
//这个是头 加载别的配置类
public class SpringConfiguration {

}
