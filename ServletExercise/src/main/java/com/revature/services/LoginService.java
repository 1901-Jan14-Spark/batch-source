package com.revature.services;

public class LoginService {

	public boolean login(String username, String password) {
		return (username.equals("admin") && password.equals("password"))?true:false;
	}
}
