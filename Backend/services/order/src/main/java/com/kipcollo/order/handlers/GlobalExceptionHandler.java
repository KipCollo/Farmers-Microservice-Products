package com.kipcollo.order.handlers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kipcollo.order.exceptions.BusinessException;
import com.kipcollo.order.exceptions.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handle(BusinessException exception){
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException exception){
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponses> handle(MethodArgumentNotValidException exception){

        HashMap<String, String> errors =new HashMap<>();
        exception.getBindingResult().getAllErrors()
            .forEach(error->{
                String fieldName = ((FieldError)error).getField();
                String errorMessage =error.getDefaultMessage();

                errors.put(fieldName,errorMessage);
            });

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ErrorResponses(errors));
    }
}
