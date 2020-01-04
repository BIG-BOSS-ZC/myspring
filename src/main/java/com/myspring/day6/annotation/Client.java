package com.myspring.day6.annotation;

import com.myspring.day5.nono.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.myspring.day6.annotation")
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(Client.class);
        UserService userService = (UserService)context.getBean("userService");
        userService.createUser();
        userService.deleteUser();
    }
}
