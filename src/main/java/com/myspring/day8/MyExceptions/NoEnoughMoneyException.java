package com.myspring.day8.MyExceptions;

public class NoEnoughMoneyException extends RuntimeException{
    public NoEnoughMoneyException(String message) {
        super(message);
    }
}
