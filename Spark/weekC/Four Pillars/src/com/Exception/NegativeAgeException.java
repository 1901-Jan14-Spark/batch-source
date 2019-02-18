package com.Exception;

public class NegativeAgeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NegativeAgeException() {
        super();
    }

    public NegativeAgeException(String message) {
        super(message);
    }

}
