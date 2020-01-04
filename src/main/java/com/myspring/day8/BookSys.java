package com.myspring.day8;

import com.myspring.day8.myConfig.BookConfig;
import com.myspring.day8.service.BookService;
import com.myspring.day8.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component("bookSys")
public class BookSys {

    @Autowired
    private BookService bookService;
    @Autowired
    private Cashier cashier;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BookConfig.class);
        BookSys bookSys = (BookSys)context.getBean("bookSys");
        bookSys.bookService.purchase("liuzhonglin",1);
        bookSys.bookService.purchase("liuzhonglin",23);
        bookSys.bookService.purchase("liuzhonglin",35);
        bookSys.cashier.checkout("liuzhonglin",bookSys.bookService.getSelectBooks());
    }
}
