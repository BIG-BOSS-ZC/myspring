package com.myspring.day7.beanxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(
                "day7trans.xml"
        );

        AccountService aSProxy =(AccountService) context.getBean("accountServiceProxy");
        aSProxy.transfer(4,5,"200");

    }
}
