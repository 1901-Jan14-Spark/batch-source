package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmployeeService implements CrudService<Employee> {
	
	EmployeeDao empDao = new EmployeeDaoImpl();

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Employee obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employee obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int validation(Employee obj) {
		
		return empDao.validate(obj.getEmail(), obj.getPassword());
	}

}
