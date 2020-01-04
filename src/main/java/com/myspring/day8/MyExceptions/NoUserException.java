package com.myspring.day8.MyExceptions;

public class NoUserException extends RuntimeException{
    public NoUserException(String message) {
        super(message);
    }
}
