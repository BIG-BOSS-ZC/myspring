package com.myspring.day3.myAnotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class MyTest3 {


    public void init() throws Exception {
        System.out.println("mytest3 初始化");
    }

    public MyTest3(){
        System.out.println("mytest3 构造了");
    }


    public void destroy() throws Exception {
        System.out.println("mytest3 销毁了");
    }

}
