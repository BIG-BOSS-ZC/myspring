package com.myspring.day2;

public class Lazy {
    private static volatile Lazy instance=null;

    public static Lazy getInstance() {
        instance=new Lazy();
        return instance;
    }
}
