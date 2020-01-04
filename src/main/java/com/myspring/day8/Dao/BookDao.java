package com.myspring.day8.Dao;

public interface BookDao {
    // 根据书号获取书的单价
    public Double findBookPriceByIsbn(int isbn);
    // 更新书的库存，使书号对应的库存-1
    public void updateBookStock(int isbn);
    // 更新用户的账户余额：account的balance-price
    public void updateUserAccount(String username, double price);
}
