package com.sdm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Author: tyza66
 * Date: 2023/6/21 13:02
 * Github: https://github.com/tyza66
 **/

@Configuration
@PropertySource("classpath:druid.properties")
public class JDBCConfig {
    @Value("${driverClassName}")
    private String driver;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;

    @Bean //属性的赋值使用过@Value("${}")注入属性值 它就是一个占位的Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "dataSource") //写在方法上用来创建对象 返回值就是要创建的对象
    //如果不写 方法名就是beanId的名称
    public DataSource getDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setUser(user);
            comboPooledDataSource.setPassword(password);
            comboPooledDataSource.setJdbcUrl(url);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return comboPooledDataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
