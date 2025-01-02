package com.librarymanagement.demo.controller;


import com.librarymanagement.demo.exception.DuplicateBookException;
import com.librarymanagement.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



/**
 * GlobalExceptionHandler is a component that provides centralized exception handling
 * across all controllers in the application. It leverages Spring's {@code @ControllerAdvice}
 * to intercept and handle specific exceptions, returning appropriate HTTP responses to the client.
 *
 * Exception Handling:
 * - Handles exceptions thrown during the execution of controller methods and converts them
 *   into standardized HTTP responses with corresponding status codes.
 * - Supports handling of custom exceptions, such as {@code DuplicateBookException} and {@code NotFoundException},
 *   as well as common exceptions like {@code IllegalArgumentException}.
 *
 * Exception Handlers:
 * 1. {@code DuplicateBookException}:
 *    - Triggered when an attempt is made to add a duplicate book to the library management system.
 *    - Returns a response with HTTP 409 Conflict status and the exception's message.
 *
 * 2. {@code NotFoundException}:
 *    - Triggered when a requested resource, such as a book, is not found.
 *    - Returns a response with HTTP 404 Not Found status and the exception's message.
 *
 * 3. {@code IllegalArgumentException}:
 *    - Triggered when invalid arguments are provided to a controller method.
 *    - Returns a response with HTTP 400 Bad Request status and the exception's message.
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String>handleIllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
