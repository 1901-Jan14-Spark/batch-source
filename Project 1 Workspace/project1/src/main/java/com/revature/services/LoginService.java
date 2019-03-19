package com.revature.services;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Employee;

public class LoginService {
	EmployeeDaoImpl ld = new EmployeeDaoImpl();
	
	public Employee getLogin(String user, String pass){
		return ld.getEmployeeBySignIn(user, pass);
	}
}
