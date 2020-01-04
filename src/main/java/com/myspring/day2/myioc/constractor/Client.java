package com.myspring.day2.myioc.constractor;

import com.myspring.day1.bean.User;
import com.myspring.day1.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    private UserService userService;

    public Client(UserService userService) {
        this.userService = userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add(User user){
        userService.addUser(user);
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User) context.getBean("user");
        Client client=(Client) context.getBean("client");
        client.userService.addUser(user);
    }
}
