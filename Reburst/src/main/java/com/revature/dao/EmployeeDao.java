package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmps();
	public Employee getUserById(int id);
	public int validate(String email, String Pass);
	public List<Employee> getEmpsReportingTo(Employee emp);
	public Employee getEmps(Employee emp);
	public int createEmp(String email, String password, int managerId);
	public boolean updateEmp(Employee emp);
	public boolean LoggedIn(Employee emp);
}
