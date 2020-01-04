package com.myspring.day8.MyExceptions;

public class StockNotEnoughException extends RuntimeException{
    public StockNotEnoughException(String message) {
        super(message);
    }
}
