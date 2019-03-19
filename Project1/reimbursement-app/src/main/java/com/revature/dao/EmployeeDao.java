package com.revature.dao;
import com.revature.model.Employee;
import java.util.List;
public interface EmployeeDao {
	public Employee getEmployeeByEmail(String email);
	public List<Employee> getAllEmployees();
	public void createEmployee(Employee e);
	public void updateEmployee(Employee e);
}
