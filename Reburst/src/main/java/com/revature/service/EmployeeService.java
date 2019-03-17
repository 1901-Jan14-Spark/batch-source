package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeService{
	
	EmployeeDao eDao = new EmployeeDaoImpl();
	
	public List<Employee> getEmployeesList(){
		return eDao.getEmps();
	
	}


	
	public int validation(Employee obj) {
		
		return eDao.validate(obj.getEmail(), obj.getPassword());
	}

}
