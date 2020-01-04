package com.myspring.day2.myioc.constractor;

import com.myspring.day1.bean.User;
import com.myspring.day1.dao.UserDao;
import com.myspring.day1.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
