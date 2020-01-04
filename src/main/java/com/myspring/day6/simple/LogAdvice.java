package com.myspring.day6.simple;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAdvice{

    public void logger(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" Spring Aop AfterReturningAdvice 测试成功！");
    }
}
