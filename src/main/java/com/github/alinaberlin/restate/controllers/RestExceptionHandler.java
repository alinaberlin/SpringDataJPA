package com.github.alinaberlin.restate.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value ={IllegalArgumentException.class, NullPointerException.class})
public  ResponseEntity<String> handleResourceNotFoundException( RuntimeException exception, WebRequest request){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry, we have an error");
    }

}
