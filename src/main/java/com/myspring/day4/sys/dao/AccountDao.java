package com.myspring.day4.sys.dao;

import com.myspring.day4.sys.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountDao {
    boolean createAccount(Account account);
    boolean deleteAccount(int id);
    boolean updateAccount(Account account);
    Account findById(int id);
    List<Account> listAll();

    boolean save(int id,BigDecimal money);
    boolean take(int id,BigDecimal money);

    Account login(String username,String password);
}
