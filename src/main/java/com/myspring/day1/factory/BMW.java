package com.myspring.day1.factory;

public class BMW implements Car{
    @Override
    public String getName() {
        System.out.println("宝马");
        return "宝马";
    }
}
