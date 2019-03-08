package services;

public class LoginService {
	public boolean verify(String name, String pass) {
		String corName = "pam";
		String corPass = "guest";
		if(name.equals(corName) && pass.equals(corPass))
			return true;
		
		return false;
	}
}
