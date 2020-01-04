package com.myspring.day3.myAnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(
                        "com.myspring.day3.myAnotation");
        context.close();

        ClassPathXmlApplicationContext context1=
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml"
                );
        context1.close();
    }
}
