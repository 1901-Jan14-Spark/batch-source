package com.revature.utils;

public class PasswordGenerator {

	// Generate a random initial password of length 10
	public static String generatePassword() {

		int characterToBeAppended;
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			if(Math.random() <= 0.8) {
			characterToBeAppended = 97 + (int) (Math.random() * (25 + 1));
			password.append((char) characterToBeAppended);
			}else {
			characterToBeAppended = (int)(Math.random()*10);
			password.append(characterToBeAppended);
			}
		}

		return password.toString();
	}
}
