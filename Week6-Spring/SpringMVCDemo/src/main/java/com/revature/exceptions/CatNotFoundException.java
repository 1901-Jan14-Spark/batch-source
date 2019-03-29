package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No cat record was found")
public class CatNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CatNotFoundException()
	{
=======
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No cat record with given id!")
public class CatNotFoundException extends RuntimeException {

	public CatNotFoundException() {
>>>>>>> Carolyn_Rehm
		super();
	}
}
