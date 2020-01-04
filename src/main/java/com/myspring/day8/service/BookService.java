package com.myspring.day8.service;

import java.util.List;

public interface BookService {
    public void purchase(String username, int isbn);
    public List<Integer> getSelectBooks();
}
