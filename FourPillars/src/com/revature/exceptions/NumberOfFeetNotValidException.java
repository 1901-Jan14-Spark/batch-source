package com.revature.exceptions;

public class NumberOfFeetNotValidException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NumberOfFeetNotValidException() {
		super();
	}
	public NumberOfFeetNotValidException(String message) {
		super(message);
	}
}
