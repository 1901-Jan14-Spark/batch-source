package com.revature.services;

public class LoginService {
	
	public String loginResult(String username, String password) {
		
		String result = "";
		
		if(username.equals("user") && password.equals("password")) {
			result = "Login Successful!";
		} else {
			result = "Invalid Username or Password!";
		}	
		return result;
	}

}
