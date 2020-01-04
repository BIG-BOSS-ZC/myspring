package com.myspring.day6.annotation.transaction;

import com.myspring.day4.sys.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
@Service("accountService")
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(int fromId, int toId, BigDecimal money) throws SQLException {
        Account from = accountDao.findById(fromId);
        Account to = accountDao.findById(toId);

        from.setMoney(from.getMoney().subtract(money));
        accountDao.update(from);
        //此处可以手动抛出一个异常，此时钱被转走，但接收者并不会收到。
//        if (true)
//        throw new RuntimeException();
        to.setMoney(to.getMoney().add(money));
        accountDao.update(to);
    }

    public void transferTwo(int fromId, int toId, BigDecimal money) throws SQLException {
        Account from = accountDao.findById(fromId);
        Account to = accountDao.findById(toId);

        try {
            System.out.println("begin");
            JdbcUtil.connection.setAutoCommit(false);
            from.setMoney(from.getMoney().subtract(money));
            accountDao.update(from);
           /* if (true)
                throw new RuntimeException();*/
            to.setMoney(to.getMoney().add(money));
            accountDao.update(to);
            System.out.println("commit");
            JdbcUtil.connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback");
                JdbcUtil.connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
