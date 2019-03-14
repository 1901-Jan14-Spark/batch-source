package dao;

import java.util.List;

import models.Employee;

public interface EmployeeDao {

	public List<Employee> getOnlyEmployees();
	public Employee getEmployeeByUsername(String username);
	
}
