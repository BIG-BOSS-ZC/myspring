package com.myspring.day4.sys.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("com.myspring.day4")
public class MyDataSource {
    @Value("${jdbcUrl}")
    private String jdbcurl;
    @Value("${myname}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${driverClass}")
    private String driverClass;

    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(jdbcurl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        return dataSource;
    }
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
