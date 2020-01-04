package com.myspring.day6.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice{

    @Pointcut("execution(* com..day6.annotation.UserServiceImpl.*(..))")
    public void pc1(){

    }
    @After("pc1()")
    public void logger(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" Spring Aop AfterReturningAdvice 测试成功！");
    }
}
