package com.myspring.day5.nono;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceImpl implements UserService{



    @Override
    public void createUser() {
        System.out.println("创建了一个用户。");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除了一个用户。");
    }

    public void aNewMethod(){
        System.out.println("这是新加的一个方法");
    }
}
