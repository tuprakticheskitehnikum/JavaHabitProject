package com.example.demo.exception;

public class FailedMailException extends RuntimeException{
    private String message;
    public FailedMailException(String message){
        super(message);
        this.message = message;
    }
    public FailedMailException(){
        super();
        this.message = "Failed to send an e-mail";
    }
    @Override
    public String getMessage(){
        return message;
    }
}
