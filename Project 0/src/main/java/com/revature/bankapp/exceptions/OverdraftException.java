package com.revature.bankapp.exceptions;

public class OverdraftException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OverdraftException() {
		
	}
	
	public OverdraftException(String message) {
		super(message);
		System.out.println(message);
	}
}
