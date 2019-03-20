package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class LoginService {
		
		EmployeeDao empDao = new EmployeeDaoImpl();
	
	public String validation(String email, String password) {
		Employee emp = empDao.getUserByEmail(email);
		try {
			if (emp.getEmail() == null) {
			String theError="Employee has no EMail: No Email of Invalid Email";
			return theError;
			}
		} catch (NullPointerException e) {
			String theError="Employee Does not Exist: No Email of Invalid Email";
			return theError;
		}if(email.matches(emp.getEmail()) && password.matches(emp.getPassword()) && emp.geteId()== 44544 && emp.getIsManager()==1) {
			String hrmanager = "hrmanager";
			
			return hrmanager;
		} 
		if(email.matches(emp.getEmail()) && password.matches(emp.getPassword()) && emp.getIsManager()==1) {
				String manager = "manager";
				
				return manager;
			} 
		if(email.matches(emp.getEmail()) && password.matches(emp.getPassword())) {
			String employee = "employee";
			
			return employee;
		} 
		else {
		String theError = "Sorry Invalid";
		return theError;
		}
	}

}
