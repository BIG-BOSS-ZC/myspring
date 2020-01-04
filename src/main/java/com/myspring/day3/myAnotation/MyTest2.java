package com.myspring.day3.myAnotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyTest2{

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("mytest2 初始化");
    }

    public MyTest2(){
        System.out.println("mytest2 构造了");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("mytest2 销毁了");
    }

}
