package com.example.taskapp_assesment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(TaskNotFoundException ex) {
        // Optional: Add logging here to log the exception details
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
