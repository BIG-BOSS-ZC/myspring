package com.myspring.day6.annotation.transaction;

import com.myspring.day4.sys.model.Account;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountDao {
    public void update(Account account) throws SQLException {
        String sql = "update account set money = " + account.getMoney() + " where id = " + account.getId();
        JdbcUtil.statement.execute(sql);
    }

    public Account findById(int id) {
        Account account = null;
        try (ResultSet rs = JdbcUtil.statement.executeQuery("select id, username, money from account where id=" + id)) {
            if (rs.next()) {
                account = new Account(rs.getInt("id"), rs.getString("username"),
                        "", rs.getBigDecimal("money"), "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
