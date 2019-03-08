package com.revature.services;

public class LoginService {

	public String confirmUsernamePassword(String input, String input2) {
		if(input.matches("admin") && input2.matches("password")) {
			String success = "You did it!!!! Successful input!";
			return success;
		} else {
		String error = "You did not input the correct username or password.";
		return error;
		}
	}

}
