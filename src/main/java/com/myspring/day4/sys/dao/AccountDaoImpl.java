package com.myspring.day4.sys.dao;

import com.myspring.day4.sys.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    @Override
    public boolean createAccount(Account account) {
        if(account==null){
            return false;
        }
        jdbcTemplate.update(
                "insert into account (username,password,money) values (?,?,?)",
                account.getUsername(),account.getPassword(),account.getMoney());
        return true;
    }

    @Override
    public boolean deleteAccount(int id) {
        jdbcTemplate.update("delete from account where id=?",id);
        return true;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }

    @Override
    public Account findById(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from account where id=?",new TheRowMapper(),id);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public List<Account> listAll() {
        try {
            return jdbcTemplate.query("select * from account",new TheRowMapper());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean save(int id,BigDecimal money) {
        Account byId = findById(id);
        if(byId==null){
            return false;
        }
        jdbcTemplate.update("update account set money=? where id=?",byId.getMoney().add(money),id);
        return true;
    }

    @Override
    public boolean take(int id,BigDecimal money) {
        Account byId = findById(id);
        if(byId==null){
            return false;
        }
        jdbcTemplate.update("update account set money=? where id=?",byId.getMoney().subtract(money),id);
        return true;
    }

    @Override
    public Account login(String username, String password) {
        try {
            return jdbcTemplate.queryForObject("select * from account where username=? and password=?",new TheRowMapper(),username,password);
        }catch (Exception e){
            return null;
        }

    }
}
