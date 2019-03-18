package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.services.daos.implementations.EmployeeDaoImplementation;
import com.revature.services.daos.interfaces.EmployeeDao;
import com.revature.utils.PasswordGenerator;

public class EmployeeService {

	private EmployeeDao ed = new EmployeeDaoImplementation();

	public boolean createEmployee(String email) throws SQLException, IOException {
		Employee e = new Employee();
		e.setEmail(email);
		e.setPassword(PasswordGenerator.generatePassword());
		e.setFirstname("Employee First Name");
		e.setLastname("Employee Last Name");
		e.setManagerLevel(0);
		int query = ed.createEmployee(e);
		return query > 0 ? true : false;
	}

	public boolean updateEmployeeInformation(Employee e) {
		Employee temp = this.getEmployeeById(e.getId());
		if (e.getEmail()  == null) {
			e.setEmail(temp.getEmail());
		}
		if (e.getPassword()  == null) {
			e.setPassword(temp.getPassword());
		}
		if (e.getFirstname() == null) {
			e.setFirstname(temp.getFirstname());
		}
		if (e.getLastname() == null) {
			e.setLastname(temp.getLastname());
		}

		e.setManagerLevel(temp.getManagerLevel());

		int query = ed.updateEmployee(e);
		return query > 0 ? true : false;
	}

	public Employee getEmployeeById(int id) {
		Employee e = ed.getEmployeeById(id);
		return e;
	}

	public Employee getEmployeeByEmail(String email) {
		Employee e = ed.getEmployeeByEmail(email);
		return e;
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = ed.getEmployees();
		return employees;
	}

}
