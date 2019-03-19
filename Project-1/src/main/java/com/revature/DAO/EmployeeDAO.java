package com.revature.DAO;

import com.revature.models.Employee;
import java.util.List;

public interface EmployeeDAO {
	public Employee varifyAccount(String username, String password);
	public int createEmployee(Employee a);
	public List<Employee> getEmployees();
	public Employee getEmpByUsername(String username);
}
