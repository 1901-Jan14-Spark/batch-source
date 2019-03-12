package services;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import models.Employee;

public class LoginService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public String confirmLogin(String email, String password) {
		Employee temp = empDao.getEmployeeByUsername(email);
		try {
			if (temp.getEmail() == null) {
			String error="nullEmail";
			return error;
		}
		} catch (NullPointerException e) {
			String error="nullEmail";
			return error;
		}
		if(email.matches(temp.getEmail()) && password.matches(temp.getPassword())) {
			String success = "success";
			return success;
		} else {
		String error = "incorrect";
		return error;
		}
	}
}
