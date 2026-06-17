package com.pluralsight.springdealership.exception;

public class DealershipNotFoundException extends RuntimeException {
    public DealershipNotFoundException(String message) {
        super(message);
    }
}
