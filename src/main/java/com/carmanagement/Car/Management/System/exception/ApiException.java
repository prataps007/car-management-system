package com.carmanagement.Car.Management.System.exception;

public class ApiException extends RuntimeException{

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }
}