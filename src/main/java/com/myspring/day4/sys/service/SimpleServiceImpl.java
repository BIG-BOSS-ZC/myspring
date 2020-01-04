package com.myspring.day4.sys.service;

import com.myspring.day4.sys.dao.AccountDao;
import com.myspring.day4.sys.dao.AccountDaoImpl;
import com.myspring.day4.sys.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service("simpleService")
public class SimpleServiceImpl implements SimpleService{
    @Autowired
    private AccountDao accountDao;
    @Override
    public void exit() {

    }

    @Override
    public BigDecimal seeMoney(int id) {
        return accountDao.findById(id).getMoney();
    }

    @Override
    public boolean save(int id, BigDecimal money) {
        return accountDao.save(id,money);
    }

    @Override
    public boolean take(int id, BigDecimal money) {
        return accountDao.take(id, money);
    }

    @Override
    public boolean transfer(int myid, int toid, BigDecimal money) {
        Account my = accountDao.findById(myid);
        Account to = accountDao.findById(toid);

        if(my==null||to==null){
            return false;
        }
        if(money.doubleValue()<0||my.getMoney().doubleValue()<money.doubleValue()){
            return false;
        }
        accountDao.take(myid,money);
        accountDao.save(toid,money);
        return true;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }
}
