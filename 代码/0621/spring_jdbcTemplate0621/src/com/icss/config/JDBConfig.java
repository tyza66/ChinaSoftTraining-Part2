package com.icss.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:druid.properties")
public class JDBConfig {
    @Value("${driverClassName}")
    private String driver;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;

// 属性赋值 @Value(${}) ${} 注入属性值  PropertySourcesPlaceholderConfigurer 占位bean
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return  new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean(name="bean的id名称") 方法上 创建对象 方法的返回值就是要创建的对象 name指定bean的id名称
//    如果不写 方法名就是bean的id名称 <bean id="名称"></bean>
    @Bean(name="dataSource")
    public DataSource getDataSource(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setUser(user);
            comboPooledDataSource.setPassword(password);
            comboPooledDataSource.setJdbcUrl(url);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }

//    方法参数 属性自动注入
    @Bean(name="jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }




}
