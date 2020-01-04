package com.myspring.day4.sys.service;

import com.myspring.day4.sys.dao.AccountDao;
import com.myspring.day4.sys.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AccountDao accountDao;
    @Override
    public void exit() {

    }

    @Override
    public boolean createAccount(Account account) {
        return accountDao.createAccount(account);
    }

    @Override
    public boolean deleteAccount(int id) {
        return accountDao.deleteAccount(id);
    }

    @Override
    public List<Account> listAll() {
        return accountDao.listAll();
    }

    @Override
    public Account login(String username, String password) {
        return accountDao.login(username,password);
    }
}
