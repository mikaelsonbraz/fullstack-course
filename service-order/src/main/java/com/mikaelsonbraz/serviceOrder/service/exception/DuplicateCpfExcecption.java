package com.mikaelsonbraz.serviceOrder.service.exception;

public class DuplicateCpfExcecption extends RuntimeException{

    public DuplicateCpfExcecption(String message) {
        super(message);
    }

    public DuplicateCpfExcecption(String message, Throwable cause) {
        super(message, cause);
    }
}
