package com.revature.exceptions;

// extending runtime exception makes this an unchecked exception
public class NegativeWheelValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegativeWheelValueException() {
		super();
	}
	
	public NegativeWheelValueException(String message) {
		super(message);
	}
	
}
