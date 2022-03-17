package com.rakib.springtransaction;

public class InsufficientAmountException extends RuntimeException {
    public InsufficientAmountException(String msg) {
        super(msg);
    }
}
