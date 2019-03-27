package com.revature.services;

import com.revature.company.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.imp.EmployeeDaoImpl;

public class LoginService {
	
	EmployeeDao ed = new EmployeeDaoImpl();
	
	public Employee loginResult(String username, String password) {		
		Employee currentEmp = ed.getEmployeeByUsername(username);
		System.out.println(username);
		System.out.println(password);
		
		if(currentEmp != null && currentEmp.getPassword().equals(password)) {
			return currentEmp;
		} else {
			return null;
		}
	}
}
