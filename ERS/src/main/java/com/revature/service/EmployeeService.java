package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.im.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public class EmployeeService {

EmployeeDao empDao = new EmployeeDaoImpl();
	
	
	public List<Employee> getAll() {
		return empDao.getEmployees();
	}

	
	public Employee getById(int id) {
		return empDao.getEmployeeById(id);
	}

	
	public int create(Employee employee) {
		return empDao.createEmployee(employee);
	}

	
	public int update(Employee employee) {
		return empDao.updateEmployee(employee);
	}

	
	public int deleteById(int id) {
		return empDao.deleteEmployeeById(id);
	}
}
