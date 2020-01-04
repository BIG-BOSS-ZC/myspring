package com.myspring.day5.nono;

import com.myspring.day5.proxy.UserServiceProxy;

public class Test {
    public static void main(String[] args) {
        UserService u=new UserServiceImpl();
        UserService userService=new UserServiceProxy(u);
        userService.createUser();
        userService.deleteUser();
    }
}
