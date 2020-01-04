package com.myspring.day7.beanxml;

import com.myspring.day4.sys.dao.AccountDaoImpl;
import com.myspring.day4.sys.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    static class TheRowMapper implements org.springframework.jdbc.core.RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account=new Account();
            account.setId(resultSet.getInt("id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword("******");
            account.setMoney(resultSet.getBigDecimal("money"));
            account.setRole(resultSet.getString("role"));
            return account;
        }
    }

    public Account findById(int id){
        System.out.println("findbyid");
        Account account=jdbcTemplate.queryForObject("select * from account where id=?",new TheRowMapper(),id);
        System.out.println(account);
        return account;
    }

    public void updateMoney(Account account){
        if(account.getMoney().doubleValue()<0){
            throw new NoEnouphMoneyException("账户余额不足");
        }
        jdbcTemplate.update("update account set money=? where id=?",account.getMoney(),account.getId());
    }

    /*public static void main(String[] args) {
        Account account=jdbcTemplate.queryForObject("select * from account where id=?",new TheRowMapper(),3);
        System.out.println(account);
    }*/
}
