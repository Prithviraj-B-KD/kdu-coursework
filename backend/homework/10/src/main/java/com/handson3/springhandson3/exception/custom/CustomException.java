package com.handson3.springhandson3.exception.custom;

public class CustomException extends IndexOutOfBoundsException{
    public CustomException(String message){
        super(message);
    }
}
