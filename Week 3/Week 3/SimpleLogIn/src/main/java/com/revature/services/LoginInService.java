package com.revature.services;

public class LoginInService {
	public int checkUser(String username, String password) {
		int result = 0;
		if(username.equals("djbogar")|| password.equals("password")) {
			result = 1;
		}
		return result;
	}
}
