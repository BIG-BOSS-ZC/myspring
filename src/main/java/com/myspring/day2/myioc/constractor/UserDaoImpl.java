package com.myspring.day2.myioc.constractor;

import com.myspring.day1.bean.User;
import com.myspring.day1.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public void addUser(User user) {
        System.out.println("add user successful :"+user.toString());
    }
}
