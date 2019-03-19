package services;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;

public class LoginService {
	EmployeesDao ed = new EmployeesDaoImpl();
	public LoginService(String user, String pass) {
		String Employee = ed.getEmployeeByUser(user, pass).getUsername();

		if(user == ed.getEmployeeByUser(user, pass).getUsername() &&
				pass == ed.getEmployeeByUser(user, pass).getPassword()){

		}

	}
}