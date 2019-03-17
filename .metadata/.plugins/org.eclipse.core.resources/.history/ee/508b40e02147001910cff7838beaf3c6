package com.revature.services;

import java.util.List;

import com.revature.company.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.dao.imp.EmployeeDaoImpl;

public class EmployeeService implements CrudService<Employee> {
	
	EmployeeDao eDao = new EmployeeDaoImpl();

	@Override
	public List<Employee> getAll() {
		return eDao.getAllEmployees();
	}

	@Override
	public Employee getById(int id) {
		return eDao.getEmployeeById(id);
	}

	@Override
	public int create(Employee e) {
		return eDao.addNewEmployee(e);
	}

	@Override
	public int update(Employee e) {
		return eDao.updateEmployee(e);
	}

	@Override
	public int deleteById(int id) {
		return eDao.deleteEmployee(id);
	}
	
	

}
