package services;

import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import models.Employee;

public class EmployeeService {
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	public List<Employee> getEmployeesList(){
		return empDao.getOnlyEmployees();
	}
	
	public int updateEmployeeInfo(Employee e) {
		return empDao.updateEmployeeInfo(e);
	}
}
