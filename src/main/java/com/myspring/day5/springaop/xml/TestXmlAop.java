package com.myspring.day5.springaop.xml;

import com.myspring.day5.nono.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlAop {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new
                ClassPathXmlApplicationContext("aoptest.xml");
        UserService userServiceProxy =(UserService) context.getBean("userService");
        userServiceProxy.deleteUser();
        userServiceProxy.createUser();
    }
}
