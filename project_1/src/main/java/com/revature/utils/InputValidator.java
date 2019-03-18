package com.revature.utils;

public class InputValidator {

	public static boolean validateId(String id) {
		if(id != null && id.matches("[0-9]+")&& id.length() == 9) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean validateEmail(String email) {
		if (email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
			return true;
		else
			return false;
	}

	public static boolean validatePassword(String password) {
		if (password != null && password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{7,}"))
			return true;
		else
			return false;
	}

	public static boolean validateName(String name) {
		if (name != null && name.length() > 0 && name.matches("[a-zA-z ]+"))
			return true;
		else
			return false;
	}

	public static boolean validateAmount(String amount) {
		if(amount != null && amount.matches("\\d+(\\.\\d{1,2})?+")&& amount.length()<13 && Double.parseDouble(amount) > 0) {
			return true;
		} else{
			return false;
		}
	}

	public static boolean validateDescription(String description) {
		if(description != null && description.length() < 199) {
			return true;
		}
		return false;
	}
	
	public static boolean validateTitle(String title) {
		if(title != null && title.length() < 50) {
			return true;
		}
		return false;
	}

	public static boolean validateManagerLevel(String managerLevel) {
		if(managerLevel != null && managerLevel.length() == 1 && managerLevel.matches("[0-1]+")) {
			return true;
		}
		return false;
	}
}
