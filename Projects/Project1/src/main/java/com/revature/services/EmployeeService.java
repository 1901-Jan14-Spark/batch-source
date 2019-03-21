package com.revature.services;

import java.util.List;

import com.revature.company.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.imp.EmployeeDaoImpl;

public class EmployeeService{
	
	EmployeeDao eDao = new EmployeeDaoImpl();

	public List<Employee> getAll() {
		return eDao.getAllEmployees();
	}

	public Employee getById(int id) {
		return eDao.getEmployeeById(id);
	}
		
	public Employee getByName(String firstName, String lastName) {
		return eDao.getEmployeeByName(firstName, lastName);
	}
	
	public Employee getByUsername(String username) {
		return eDao.getEmployeeByUsername(username);
	}

	public int create(Employee e) {
		return eDao.addNewEmployee(e);
	}

	public int update(Employee e) {
		return eDao.updateEmployee(e);
	}

	public int deleteById(int id) {
		return eDao.deleteEmployee(id);
	}
}
