package com.n1k0.RESTtest.exception;

public class ToDoNotFoundException extends Exception {
    public ToDoNotFoundException(String message) {
        super(message);
    }
}
