package com.myspring.day5.nono;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceImpl2 implements UserService{

    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void createUser() {
        System.out.println("创建了一个用户。");
        System.out.println("[Info]"+format.format(new Date())
        +" Method createUser invoked");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除了一个用户。");
        System.out.println("[Info]"+format.format(new Date())
                +" Method deleteUser invoked");
    }

    @Override
    public void aNewMethod() {

    }
}
