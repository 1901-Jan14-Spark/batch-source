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
	
	public Employee getEmployeeByEmail(String email) {
		return eDao.getUserByEmail(email);
	}
	
	public int resolveEmployees(Employee e) {
		return eDao.updateEmp(e);
	}
	
	public int createEmployee(Employee e) {
		System.out.println("create employee service");
		return eDao.createEmp(e);
	}

}
