package com.sdm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Author: tyza66
 * Date: 2023/6/21 13:02
 * Github: https://github.com/tyza66
 **/

@Configuration
@PropertySource("classpath:jdbc.properties")
public class jdbcConfig {
    @Value("${driverClassName}")
    private String driver;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;

    @Bean(name = "dataSource")
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
}
