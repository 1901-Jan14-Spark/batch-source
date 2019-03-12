package dao;

import java.util.List;

import models.Employee;

public interface EmployeeDao {

	public String loginCheck(String username, String password);
	public List<Employee> retrieveEmployees();
	public Employee getEmployeeByUsername(String username);
	
}
