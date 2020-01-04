package com.myspring.day8.MyExceptions;

public class NoBookIsbnException extends RuntimeException{
    public NoBookIsbnException(String message) {
        super(message);
    }
}
