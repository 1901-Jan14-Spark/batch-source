package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public interface EmployeeDao {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByEmail(String email);
	public int createEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployeeById(int id);
}
