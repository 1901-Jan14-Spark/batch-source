package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.im.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public class EmployeeService implements CrudService<Employee> {

	EmployeeDao empDao = new EmployeeDaoImpl();
	
	@Override
	public List<Employee> getAll() {
		return empDao.getEmployees();
	}

	
	public Employee getById(int id) {
		return empDao.getEmployeeById(id);
	}

	@Override
	public int create(Employee employee) {
		return empDao.createEmployee(employee);
	}

	@Override
	public int update(Employee employee) {
		return empDao.updateEmployee(employee);
	}

	@Override
	public int deleteById(int id) {
		return empDao.deleteEmployeeById(id);
	}
	public Employee getByUsername(String username) {
		return empDao.getEmployeeByUsername(username);
	}


	@Override
	public List<Reimbursement> getByEId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
