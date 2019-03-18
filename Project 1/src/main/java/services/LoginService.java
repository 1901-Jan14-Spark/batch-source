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
		if(email.matches(temp.getEmail()) && password.matches(temp.getPassword()) && temp.getReportsTo() == 0) {
				String manager = "manager";
				//invoke method that changes loggedIn value in SQL table from 0 to 1
				return manager;
			} 
		if(email.matches(temp.getEmail()) && password.matches(temp.getPassword()) && temp.getReportsTo() > 0) {
			String employee = "employee";
			//invoke method that changes loggedIn value in SQL table from 0 to 1
			return employee;
		}  else {
		String error = "incorrect";
		return error;
		}
	}
}
