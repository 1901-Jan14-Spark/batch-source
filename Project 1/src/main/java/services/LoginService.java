package services;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import models.Employee;

public class LoginService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public Employee confirmLogin(String email, String password) {
		Employee temp = empDao.getEmployeeByUsername(email);
		try {
			if (temp.getEmail().equals(null)) {
				temp.setEmail("nullEmail");
				return temp;
		} 
		} catch (NullPointerException e) {
				temp.setEmail("nullEmail");
				return temp;
			}
		if(email.matches(temp.getEmail()) && password.matches(temp.getPassword()) && temp.getReportsTo() == 0) {
				//invoke method that changes loggedIn value in SQL table from 0 to 1
				return temp;
			} 
		if(email.matches(temp.getEmail()) && password.matches(temp.getPassword()) && temp.getReportsTo() > 0) {
			//invoke method that changes loggedIn value in SQL table from 0 to 1
			return temp;
		}  else {
		temp.setEmail("incorrect");
		return temp;
		}
	}
}
