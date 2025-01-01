package com.librarymanagement.demo.controller;


import com.librarymanagement.demo.exception.DuplicateBookException;
import com.librarymanagement.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler handles exceptions that are thrown during the execution of the application and provides an appropriate response.
 * This class defines specific exception handlers for commonly occurring exceptions in the application, such as:
 * 1. DuplicateBookException - Occurs when attempting to add a book that already exists based on title and author.
 * 2. NotFoundException - Occurs when a requested resource (e.g., book) is not found.
 * It returns appropriate HTTP status codes and error messages in response to these exceptions.
 */


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity<String>handleDuplicateBookException(DuplicateBookException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String>handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

}
