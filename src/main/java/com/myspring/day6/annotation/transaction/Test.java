package com.myspring.day6.annotation.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.myspring.day6.annotation.transaction")
public class Test {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(Test.class);
        AccountService accountService=(AccountService) context.getBean("accountService");
        accountService.transferTwo(3,2,new BigDecimal(100));
    }
}
