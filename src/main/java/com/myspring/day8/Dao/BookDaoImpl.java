package com.myspring.day8.Dao;

import com.myspring.day8.MyExceptions.NoBookIsbnException;
import com.myspring.day8.MyExceptions.NoEnoughMoneyException;
import com.myspring.day8.MyExceptions.NoUserException;
import com.myspring.day8.MyExceptions.StockNotEnoughException;
import com.myspring.day8.model.Book;
import com.myspring.day8.model.BookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static class BookRowMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book=new Book();
            book.setIsbn(resultSet.getInt("isbn"));
            book.setPrice(resultSet.getDouble("price"));
            book.setStock(resultSet.getInt("stock"));
            return book;
        }
    }

    public static class BookUserkRowMapper implements RowMapper<BookUser>{
        @Override
        public BookUser mapRow(ResultSet resultSet, int i) throws SQLException {
            BookUser bookUser=new BookUser();
            bookUser.setId(resultSet.getInt("id"));
            bookUser.setUsername(resultSet.getString("username"));
            bookUser.setMoney(resultSet.getDouble("money"));
            return bookUser;
        }
    }

    @Override
    public Double findBookPriceByIsbn(int isbn) {
        try {
            Book book = jdbcTemplate.queryForObject("select * from book where isbn=?", new BookRowMapper(), isbn);
            if(book.getStock()<=0){
                throw new StockNotEnoughException("库存不足");
            }
            return book.getPrice();
        }catch (StockNotEnoughException e){
            e.printStackTrace();
            return -1000d;
        }catch (EmptyResultDataAccessException e){
            NoBookIsbnException exception=new NoBookIsbnException("没有找到此isbn的书籍！");
            exception.printStackTrace();
            return -1000d;
        }

    }

    @Override
    public void updateBookStock(int isbn) {
        jdbcTemplate.update("update book set stock=stock-1 where isbn=?",isbn);
    }

    @Override
    public void updateUserAccount(String username, double price) {
        BookUser bookUser=null;
        try {
            bookUser = jdbcTemplate.queryForObject("select * from bookuser where username=?", new BookUserkRowMapper(), username);
        }catch (Exception e){
            throw new NoUserException("该用户不存在！");
        }
        if(bookUser.getMoney()<price){
            throw new NoEnoughMoneyException("账户余额不足！");
        }
        jdbcTemplate.update("update bookuser set money=money-? where username=?",price,username);
    }
}
