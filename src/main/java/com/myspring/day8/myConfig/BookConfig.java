package com.myspring.day8.myConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("com.myspring.day8")
public class BookConfig {
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

    @Bean("transactionManager")
    public PlatformTransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
//        禁止内部事务在出错时设置“rollback-only”
//        manager.setGlobalRollbackOnParticipationFailure(false);
        return manager;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
