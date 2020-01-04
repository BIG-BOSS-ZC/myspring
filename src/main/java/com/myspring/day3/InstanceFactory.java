package com.myspring.day3;

import com.myspring.day1.bean.User;

public class InstanceFactory {
    public User getUser(){
        return new User("1990","lzlsb");
    }
}
