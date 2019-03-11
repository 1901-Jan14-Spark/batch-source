package com.revature.services;

public class LoginInService {
	public int checkUser(String username, String password) {
		int response = 0;
		if(username.equals("djbogar")|| password.equals("password")) {
			response = 1;
		}
	return response;
	}
}
