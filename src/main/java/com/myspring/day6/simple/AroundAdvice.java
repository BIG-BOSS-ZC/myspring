package com.myspring.day6.simple;
import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始执行。。。");
        Object obj=joinPoint.proceed(joinPoint.getArgs());
        System.out.println("结束执行。。。");
        return obj;
    }
}
