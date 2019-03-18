package com.revature.services.daos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();
	public Employee getEmployeeByEmail(String email);
	public Employee getEmployeeById(int id);
	public int createEmployee(Employee e) throws SQLException, IOException;
	public int updateEmployee(Employee e);
	
}
