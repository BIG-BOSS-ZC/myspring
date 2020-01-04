package com.myspring.day3;

import com.myspring.day1.bean.User;

public class StaticFactory {
    public static User getUser(){
        return new User("1990","lzlsb");
    }
}
