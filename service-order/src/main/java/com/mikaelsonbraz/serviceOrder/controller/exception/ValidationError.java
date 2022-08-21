package com.mikaelsonbraz.serviceOrder.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errorList = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getErrorList() {
        return errorList;
    }

    public void addErrors(String fieldName, String message) {
        this.errorList.add(new FieldMessage(fieldName, message));
    }
}
