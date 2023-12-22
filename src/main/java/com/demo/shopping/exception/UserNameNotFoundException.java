package com.demo.shopping.exception;

public class UserNameNotFoundException extends RuntimeException{
    private String message;
    public UserNameNotFoundException(String message){
        super(message);
    }


}
