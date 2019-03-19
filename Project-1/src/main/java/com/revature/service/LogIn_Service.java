package com.revature.service;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAO_Impl;
import com.revature.DAO.ManagerDAO;
import com.revature.DAO.ManagerDAO_Impl;
import com.revature.models.Employee;
import com.revature.models.Manager;

public class LogIn_Service {
	
	
	
	public static int varifyEmp(String position, String username, String password) {
		if(position.equals("Employee")) {
	try {	
		EmployeeDAO aa=new EmployeeDAO_Impl();
		Employee emp=aa.varifyAccount(username, password);
		System.out.println(username +" " + password);
		System.out.println(emp.getUsername());
		if(username.equals(emp.getUsername()) && password.equals(emp.getPassword())) {
			return 1;
		}else {
			return 0;
		}
		
		}catch(NullPointerException e) {
			return 0;
		}
}else {
	try {	
		ManagerDAO aa=new ManagerDAO_Impl();
		Manager mng=aa.varifyAccount(username, password);
		System.out.println(username +" " + password);
		System.out.println(mng.getUsername());
		if(username.equals(mng.getUsername()) && password.equals(mng.getPassword())) {
			return 2;
		}else {
			return 0;
		}
		
		}catch(NullPointerException e) {
			return 0;
		}
}
	}
}
