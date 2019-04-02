package com.revature.service;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	// this is my service endpoint interface
	
	String sayHi(String text);

}
