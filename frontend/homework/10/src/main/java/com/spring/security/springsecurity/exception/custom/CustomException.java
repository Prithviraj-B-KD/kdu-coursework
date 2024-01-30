package com.spring.security.springsecurity.exception.custom;

public class CustomException extends IndexOutOfBoundsException{
    public CustomException(String message){
        super(message);
    }
}
