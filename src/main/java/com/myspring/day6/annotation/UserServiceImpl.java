package com.myspring.day6.annotation;

import com.myspring.day5.nono.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Override
    public void createUser() {
        System.out.println("创建了一个用户。");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除了一个用户。");
    }

    @Override
    public void aNewMethod() {

    }
}
