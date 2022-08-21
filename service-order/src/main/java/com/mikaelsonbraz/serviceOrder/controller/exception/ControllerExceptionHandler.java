package com.mikaelsonbraz.serviceOrder.controller.exception;

import com.mikaelsonbraz.serviceOrder.service.exception.DuplicateCpfExcecption;
import com.mikaelsonbraz.serviceOrder.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException objectNotFoundException){
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(DuplicateCpfExcecption.class)
    public ResponseEntity<StandardError> duplicateCpfException(DuplicateCpfExcecption duplicateCpfExcecption){
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), duplicateCpfExcecption.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
}
