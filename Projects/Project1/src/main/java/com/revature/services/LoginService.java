package com.revature.services;

import com.revature.company.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.imp.EmployeeDaoImpl;

public class LoginService {
	
	EmployeeDao ed = new EmployeeDaoImpl();
	
	public Employee loginResult(String username, String password) {		
		Employee currentEmp = ed.getEmployeeByUsername(username);
		if(username != null && password != null) {
			String passwordString = currentEmp.getPassword();	
			if(password.equals(passwordString)){
				return currentEmp;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
