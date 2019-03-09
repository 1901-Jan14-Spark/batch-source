package com.revature.Service;

public class LogInService {

	public static boolean varify(String username, String password) {
//		username="username";
//		password="password";
	try {	System.out.println(username +" " + password);
		if(username.equals("username") && password.equals("password")) {
			return true;
		}else {
			return false;
		}}catch(NullPointerException e) {
			return false;
		}
	}
}
