package com.myspring.day8.service;

import com.myspring.day8.Dao.BookDao;
import com.myspring.day8.MyExceptions.NoBookIsbnException;
import com.myspring.day8.model.Book;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("bookService")
public class BookServiceImpl implements BookService{
    private List<Integer> selectBooks=new ArrayList<>();
    @Autowired
    private BookDao bookDao;

    public List<Integer> getSelectBooks() {
        return selectBooks;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, int isbn) {
        Double bookPriceByIsbn = bookDao.findBookPriceByIsbn(isbn);
        if (bookPriceByIsbn>0){
            selectBooks.add(isbn);
        }else {
//            throw new NoBookIsbnException("没有找到此isbn的书籍");
        }
    }
}
