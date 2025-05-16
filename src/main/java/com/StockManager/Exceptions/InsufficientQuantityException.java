package com.StockManager.Exceptions;

public class InsufficientQuantityException extends RuntimeException{


    public InsufficientQuantityException(String msg){
        super(msg);
    }
}
