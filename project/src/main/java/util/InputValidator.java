package util;

public class InputValidator {

	public static boolean validateName(String name) {
		if (name.length() > 0 && name.matches("[a-zA-z ]+"))
			return true;
		else
			return false;
	}
	
	public static boolean validateUser(String name) {
		if (name.length() > 4 && name.matches("[a-zA-z0-9]+"))
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
}
