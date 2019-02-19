package com.tranhuu.exceptions;

public class MyOutOfBoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyOutOfBoundException() {
		
	}
	
	public MyOutOfBoundException(String message) {
		super(message);
	}

	
}
