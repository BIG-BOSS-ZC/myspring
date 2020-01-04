package com.myspring.day7.transxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(
             "transactonTest2.xml"
        );

        AccountService accountService =(AccountService) context.getBean("accountService");
        accountService.transfer(3,4,"100");
    }
}
