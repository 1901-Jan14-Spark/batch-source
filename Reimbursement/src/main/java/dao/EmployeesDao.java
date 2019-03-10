package dao;

import java.util.List;

import models.Employees;

public interface EmployeesDao {
	public List<Employees> getEmployees();
	public List<Employees> getManagers();
	
}
