package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	Employee getEmployeeById(int id, Connection con);
	public int createEmployee(Employee employee);
	Employee getEmployeeByUsername(String username);
	void updateEmployee(Employee e);
}
