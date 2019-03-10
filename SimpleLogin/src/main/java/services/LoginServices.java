package services;

public class LoginServices {
	
public static boolean validate(String username, String password) {		
		if(username.equals("admin") && password.equals("password")) {
			return true;
		} else {
			return false;		}	
	}
	
	
}
