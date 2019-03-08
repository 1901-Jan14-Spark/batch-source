package com.revature.services;

public class LoginService {

	public boolean validate(String username, String password) {
		return (username.equals("dtran") && password.equals("pass")) ? true : false;
	}
	
}
