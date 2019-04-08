package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.intercom.ReimbursementClient;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public class EmployeeController {
	
	private Logger log = Logger.getLogger(EmployeeController.class);
	
	private List<Employee> employees = new ArrayList<>();
	
	@Autowired
	ReimbursementClient reimbursementClient;
	
	public EmployeeController() {
		super();
		employees.add(new Employee(1, "Kelby", null));
		employees.add(new Employee(2, "Andrew", null));
		employees.add(new Employee(3, "Vjay", null));
	}
	
	@GetMapping 
	public List<Employee> getAllEmployees() {
		log.info("getting all employees");
		return employees;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId")Integer employeeId) {
		log.info("getting employee by id" + employeeId);
		Employee employee = employees.stream()
				.filter(emp -> emp.getEmployeeId()==employeeId)
				.findFirst().get();
		List<Reimbursement> reimbursements = reimbursementClient.getReimbursementsByEmployeeId(employeeId);
		employee.setReimbursements(reimbursements);
		return employee;
	
	}

}
