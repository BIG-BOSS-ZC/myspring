package com.myspring.day4.sys.service;

import com.myspring.day4.sys.model.Account;

import java.util.List;

public interface AdminService {
    /*
管理员账号：
退出
创建账户
删除账户
账户列表*/

    void exit();
    boolean createAccount(Account account);
    boolean deleteAccount(int id);
    List<Account> listAll();

    Account login(String username,String password);
}
