package com.myspring.day7.transxml;


import com.myspring.day4.sys.model.Account;

import java.math.BigDecimal;

public class AccountService {
    private AccountDao accountDao;

    public void transfer(int fromid,int toid,String moneyStr){
        BigDecimal money=new BigDecimal(moneyStr);
        Account fr = accountDao.findById(fromid);
        Account to = accountDao.findById(toid);
        fr.setMoney(fr.getMoney().subtract(money));
        to.setMoney(to.getMoney().add(money));
        accountDao.updateMoney(fr);
        accountDao.updateMoney(to);
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao=accountDao;
    }
}
