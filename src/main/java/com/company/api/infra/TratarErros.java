package com.company.api.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class TratarErros {

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity error404(){

        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(){

        return ResponseEntity.badRequest().build();

    }

}
