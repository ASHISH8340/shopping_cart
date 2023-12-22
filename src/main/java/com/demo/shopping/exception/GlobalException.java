package com.demo.shopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserException(UserNameNotFoundException ex){
//        String message=ex.getMessage();
//        ErrorDetails errorDetails = new ErrorDetails();
//        errorDetails.setMessage(message);
//        errorDetails.setDate(LocalDate.now());
//        errorDetails.setErrorCode(505);


        ErrorDetails errorDetails1 = ErrorDetails.builder().message(ex.getMessage()).errorCode(101000000)
                .date(LocalDate.now()).build();
        return new ResponseEntity<>(errorDetails1, HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
    }

}
