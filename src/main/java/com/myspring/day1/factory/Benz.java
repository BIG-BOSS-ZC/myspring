package com.myspring.day1.factory;

public class Benz implements Car{
    @Override
    public String getName() {
        System.out.println("奔驰");
        return "奔驰";
    }
}
