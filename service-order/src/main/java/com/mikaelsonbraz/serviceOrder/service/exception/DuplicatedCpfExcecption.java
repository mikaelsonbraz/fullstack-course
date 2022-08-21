package com.mikaelsonbraz.serviceOrder.service.exception;

public class DuplicatedCpfExcecption extends RuntimeException{

    public DuplicatedCpfExcecption(String message) {
        super(message);
    }

    public DuplicatedCpfExcecption(String message, Throwable cause) {
        super(message, cause);
    }
}
