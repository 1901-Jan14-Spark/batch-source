package services;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import delegates.ViewDelegate;
import models.Employee;

public class LoginService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	ViewDelegate viewDel = new ViewDelegate();
	
	public Employee confirmLogin(String email, String password) {
		Employee temp = empDao.getEmployeeByUsername(email);
		System.out.println(email);
		System.out.println(password);
		
		try {
			if (temp == null) {
				temp.setEmail("incorrect");
				return temp;
			} else {
				if (email.matches(temp.getEmail()) && password.matches(temp.getPassword()) && temp.getReportsTo() == 0) {
					System.out.println("correct");
					//invoke method that changes loggedIn value in SQL table from 0 to 1
					return temp;
				} else {
					if(email.matches(temp.getEmail()) && password.matches(temp.getPassword()) && temp.getReportsTo() > 0) {
						//invoke method that changes loggedIn value in SQL table from 0 to 1
						return temp;
					} 
				}
			}
		} catch (NullPointerException e) {
				return temp;		
			}
		temp.setEmail("incorrect");
		return temp;
	}
}
