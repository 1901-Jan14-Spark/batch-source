package com.revature.exceptions;

public class NegativeLegsValueException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// this will be the unchecked exception handler (runtime error) for when a user creates an animal with a negative number of legs
    public NegativeLegsValueException(){
        super();
    }
    
    public NegativeLegsValueException(String message){
        super(message);
    }
}