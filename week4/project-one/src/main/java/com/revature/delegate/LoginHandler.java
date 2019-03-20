package com.revature.delegate;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class LoginHandler {

	
	
	
	private Employee emp;
	EmployeeService eService;
	
	
	
	
	
	public LoginHandler() {
		super();
		this.emp = new Employee();
		this.eService = new EmployeeService();
	}



	public Employee validateCredental(String password, String username) {
		
		Employee e = eService.getByUsername(username);
		
		if (e != null) {
			
			
			if(  e.getProfile().getPassword().contains(password)) {
			  return e;
		         
		}
		
		
		return null;
		
	}
	return null;
	
	}
}

	

	
	
	
	
	

