package com.myspring.day1.app;

import com.myspring.day1.bean.User;
import com.myspring.day1.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class Client {
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User) context.getBean("user");
        Client client=(Client) context.getBean("client");
        client.userService.addUser(user);
    }
}
