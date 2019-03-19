package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmps();
	public Employee getUserByEmail(String Email);
	public int validate(String email, String Pass);
	public List<Employee> getEmpsReportingTo(Employee emp);
	public Employee getEmps(Employee emp);
	public int createEmp(String fname, String lName, String email, String pass, String title, int mId);
	public int updateEmp(String fname, String lName, String email, String pass, int id);
	public boolean LoggedIn(Employee emp);
}
