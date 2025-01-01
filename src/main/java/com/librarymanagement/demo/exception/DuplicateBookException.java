package com.librarymanagement.demo.exception;

public class DuplicateBookException extends RuntimeException{
    public DuplicateBookException(String message){
        super(message);
    }
}
