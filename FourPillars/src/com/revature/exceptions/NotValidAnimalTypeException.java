package com.revature.exceptions;

public class NotValidAnimalTypeException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public NotValidAnimalTypeException() {
		super();
	}
	public NotValidAnimalTypeException(String message) {
		super(message);
	}
}
