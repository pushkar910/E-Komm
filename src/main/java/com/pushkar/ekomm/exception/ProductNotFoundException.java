package com.pushkar.ekomm.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message){
        super(message);
    }
}
