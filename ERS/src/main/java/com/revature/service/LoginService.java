package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.dao.im.EmployeeDaoImpl;
import com.revature.model.Employee;

public class LoginService {
	
	EmployeeDao eDao = new EmployeeDaoImpl();
	
	public String redirectLogin(String email, String password) {
		
		Employee tempE = eDao.getEmployeeByEmail(email);
		//System.out.println(tempE.toString());
		try {
			if (tempE.getEmail() == null) {
			String status="invalidEmail";
			return status;
		}
		} catch (NullPointerException e) {
			String status="invalidEmail";
			return status;
		}
		if(email.matches(tempE.getEmail()) && password.matches(tempE.getPass()) && tempE.getReportsto() == 0) {
				return "manager";
			} 
		if(email.matches(tempE.getEmail()) && password.matches(tempE.getPass()) && tempE.getReportsto() > 0) {
			return "employee";
		}  else {
		return "incorrect";
		}
	}
}


