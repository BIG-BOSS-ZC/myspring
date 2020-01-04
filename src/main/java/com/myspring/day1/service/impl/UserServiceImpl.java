package com.myspring.day1.service.impl;

import com.myspring.day1.bean.User;
import com.myspring.day1.dao.UserDao;
import com.myspring.day1.dao.impl.UserDaoImpl;
import com.myspring.day1.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
