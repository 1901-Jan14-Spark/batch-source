package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployeesAssociatedTo(Employee e);
	
	public List<Employee> getEmployees();

	public Employee getEmployee(Employee e);

	public int createEmployee(String email, String password, int managerId);

	public boolean updateEmployeeInfo(Employee e);
	
	public boolean changeLoggedInField(Employee e);
	
	public void upgradeToManager(Employee e);

	Employee getEmployeeByEmail(String email);
	
}
