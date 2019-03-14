package services;

import dao.EmpDao;
import dao.EmpDaoImpl;
import model.EmpObj;

public class LoginService {
	//method checks DB to see if user id exists
	//check first digit of id:
	//0 -> invalid user id
	//1 -> employee id 
	//2 -> manager id
	public int verify(int id, String password) {
		//return invalid user state by default
		int status = 0;
		if(id != 0) {
			EmpDao ed = new EmpDaoImpl();
			EmpObj credential = ed.getIdAndPass(id);
			
			int storedId = credential.geteId();
			String storedPass = credential.getePass();
			
			//check if user inputs matches stored records
			if(id == storedId && password.equals(storedPass)) {
				status = id/10000;//returns first digit
			}
		}
		return status;
	}
	
	//method checks if user enters a valid number
	public int validIdInput(String inputId) {
		int output = 0;
		if("".equals(inputId))
			return 0;
		
		else {
			try {//incase user somehow enters non int values
				output = Integer.parseInt(inputId);
			}
			catch(NumberFormatException ex) {
				//suppress exception and return 0
			}
		}
		
		return output;
	}
}
