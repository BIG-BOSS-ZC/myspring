package com.myspring.day6.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(
            "transaction.xml"
        );
        AccountService accountService=(AccountService) context.getBean("accountService");
        accountService.transferTwo(3,2,new BigDecimal(100));
    }
}
