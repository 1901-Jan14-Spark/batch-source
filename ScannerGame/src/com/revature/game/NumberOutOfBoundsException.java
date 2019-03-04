package com.revature.game;

public class NumberOutOfBoundsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NumberOutOfBoundsException(){
		super();
	}
	public NumberOutOfBoundsException(String message) {
		super(message);
	}
}
