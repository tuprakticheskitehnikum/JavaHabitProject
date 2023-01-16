package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException {
    private String message;
    public UserNotFoundException(String message){
        super(message);
        this.message = message;
    }
    public UserNotFoundException(){
        super();
        this.message = "User Not Found Exception exception";
    }
    @Override
    public String getMessage(){
        return message;
    }
}
