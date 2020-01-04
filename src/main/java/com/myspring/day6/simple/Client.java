package com.myspring.day6.simple;

import com.myspring.day5.nono.UserService;
import com.myspring.day5.nono.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new
                ClassPathXmlApplicationContext("aoptest2.xml");
        UserService userService = (UserService)context.getBean("userService");
        userService.createUser();
        userService.deleteUser();
        userService.aNewMethod();
    }
}
