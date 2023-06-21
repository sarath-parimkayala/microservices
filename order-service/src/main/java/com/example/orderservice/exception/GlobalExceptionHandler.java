package com.example.orderservice.exception;

import com.example.orderservice.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception){
       ErrorResponse errorResponse =  ErrorResponse.builder().errorCode(exception.getMessage())
                .errorMessage(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getStatus()));
    }
}
