package com.revature.services;

import com.revature.models.Employee;
import com.revature.services.daos.implementations.EmployeeDaoImplementation;
import com.revature.services.daos.interfaces.EmployeeDao;

public class LoginService {

	private EmployeeDao ed = new EmployeeDaoImplementation();
	
	public Employee login(String email, String password) {
		System.out.println();
		Employee e = ed.getEmployeeByEmail(email);
		if(e != null && e.getPassword().equals(password)) {
			return e;
		}else {
			return null;
		}
	}
}
