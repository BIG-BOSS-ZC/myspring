package com.myspring.day3.myAnotation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyTest1 implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("mytest1 初始化");
    }

    public MyTest1(){
        System.out.println("mytest1 构造了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("mytest1 销毁了");
    }

}
