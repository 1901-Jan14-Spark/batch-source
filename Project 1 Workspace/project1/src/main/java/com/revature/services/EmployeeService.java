package com.revature.services;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeService implements CrudService<Employee>{

	EmployeeDao ed = new EmployeeDaoImpl();
	
	@Override
	public List<Employee> getAll() {
		return ed.getEmployees();
	}

	@Override
	public Employee getById(int id) {
		return ed.getEmployeeId(id);
	}

	@Override
	public int create(Employee employee) {
		return ed.createEmployee(employee);
	}

	@Override
	public int update(Employee employee) {
		return ed.updateEmployee(employee);
	}

	@Override
	public int deleteById(int id) {
		return ed.deleteEmployee(id);
	}
	
}
