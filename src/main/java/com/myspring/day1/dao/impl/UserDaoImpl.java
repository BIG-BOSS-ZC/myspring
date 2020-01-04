package com.myspring.day1.dao.impl;

import com.myspring.day1.bean.User;
import com.myspring.day1.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        System.out.println("add user successful :"+user.toString());
    }
}
