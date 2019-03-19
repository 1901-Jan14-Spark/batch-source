package dao;

import java.util.List;

import models.Employees;

public interface EmployeesDao {
	public List<Employees> getAll();
	public List<Employees> getEmployees();
	public List<Employees> getManagers();
	public Employees getEmployeesById(int id);
	public int createEmployee(Employees emp);
	public int updateEmployee(Employees emp);
	public int deleteEmployeesById(int id);
	Employees getEmployeesByIsMana(int stat);
	Employees getEmployeeByUser(String user, String pass);

//view all
	//all pending
	//all resolved
	//all per employee
	//
}
