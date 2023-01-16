package com.example.demo.exception;

public class UserAlreadyExistException extends RuntimeException {
    private String message;
    public UserAlreadyExistException(String message){
        super(message);
        this.message = message;
    }
    public UserAlreadyExistException(){
        super();
        this.message = "User already exists exception";
    }
    @Override
    public String getMessage(){
        return message;
    }
}
