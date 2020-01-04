package com.myspring.day5.springaop.xml;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Spring Aop AfterReturningAdvice 测试成功！");
    }
}
