package com.revature.utils;

public class InputValidator {

	public static boolean validateEmail(String email) {
		if (email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"))
			return true;
		else
			return false;
	}

	public static boolean validatePassword(String password) {
		if (password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{7,}"))
			return true;
		else
			return false;
	}

	public static boolean validateName(String name) {
		if (name.length() > 0 && name.matches("[a-zA-z ]+"))
			return true;
		else
			return false;
	}

}
