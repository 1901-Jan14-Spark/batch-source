package com.Company.Exception;

public class NumberOutOfRangeException extends  RuntimeException {

    private static final long serialVersionUID = 1L;

    public NumberOutOfRangeException() {
        super();
    }

    public NumberOutOfRangeException (String message) {
        super(message);
    }

}
