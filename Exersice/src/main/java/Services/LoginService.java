package Services;

public class LoginService {

	public boolean evaluate(String user, String pass) {
		boolean eval = false;
		if(user.equals("agilay")&&pass.equals("555")) {
			eval = true;
		}
		return eval;
	}
	
	
}
