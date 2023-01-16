package com.example.demo.exception;

public class RoleNotFoundException extends RuntimeException {
    private String message;
    public RoleNotFoundException(String message){
        super(message);
        this.message = message;
    }
    public RoleNotFoundException(){
        super();
        this.message = "Role not found exception";
    }
    @Override
    public String getMessage(){
        return message;
    }
}
