package com.revature.services;

import com.revature.company.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.imp.EmployeeDaoImpl;

public class LoginService {
	
	public int loginResult(String username, String password) {
		int result = 0;
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee currentEmp = ed.getEmployeeByUsername(username);
		
		if(username != null && password != null) {
			String passwordString = currentEmp.getPassword();	
			if(password.equals(passwordString)){
				result = 1;
			}
		}
		return result;
	}
	
	

}
