package com.myspring.day3;

import com.myspring.day1.bean.User;
import com.myspring.day3.annotation.MyAnnotation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@MyAnnotation(value = "lzlsb",locations = {"ioc.xml","aop.doc"})
public class Test {
    @MyAnnotation
    private String a;
    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("factest.xml");
        User user=(User) context.getBean("user");
        System.out.println(user);*/

        MyAnnotation myAnnotation=Test.class.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());
        Arrays.asList(myAnnotation.locations()).forEach(
                System.out::println
        );

    }
}
