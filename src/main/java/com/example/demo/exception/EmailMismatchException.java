package com.example.demo.exception;

public class EmailMismatchException extends RuntimeException {
    private String message;
    public EmailMismatchException(String message){
        super(message);
        this.message = message;
    }
    public EmailMismatchException(){
        super();
        this.message = "Email Mismatch";
    }
    @Override
    public String getMessage(){
        return message;
    }
}
