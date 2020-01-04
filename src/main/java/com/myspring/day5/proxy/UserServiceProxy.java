package com.myspring.day5.proxy;

import com.myspring.day5.nono.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy implements UserService {

    private UserService userService;
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser() {
        userService.createUser();
        System.out.println("[Info]"+format.format(new Date())
                +" Method createUser invoked");
    }

    @Override
    public void deleteUser() {
        userService.deleteUser();
        System.out.println("[Info]"+format.format(new Date())
                +" Method deleteUser invoked");
    }

    @Override
    public void aNewMethod() {

    }
}
