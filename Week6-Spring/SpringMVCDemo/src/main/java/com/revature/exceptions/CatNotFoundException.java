package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No cat record with given id!")
public class CatNotFoundException extends RuntimeException {

	public CatNotFoundException() {
		super();
	}
}
