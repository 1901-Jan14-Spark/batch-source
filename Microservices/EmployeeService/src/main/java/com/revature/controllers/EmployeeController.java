package com.revature.controllers;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.ReimbursementClient;
import com.revature.models.Reimbursement;
import com.revature.models.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private Logger log = Logger.getLogger(EmployeeController.class);
	
	private List<Employee> employees = new ArrayList<>();
	
	@Autowired
	ReimbursementClient reimbursementClient;
	
	public EmployeeController() {
		super();
		employees.add(new employee(1, "Jeff Patrick", "jpat@gmail.com", null));
		employees.add(new employee(2, "Bod Hanson", "hbod@gmail.com", null));
		employees.add(new employee(3, "Sarah Jones", "sarahjones@gmail.com", null));
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		log.info("getting all employees");
		return employees;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId")Integer employeeId) {
		log.info("getting employee by id:" + employeeId);
		employee employee = employees.stream()
				.filter(emp -> emp.getemployeeId()==employeeId)
				.findFirst().get();
		List<Reimbursement> reimbursements = reimbursementClient.getReimbursementsByEmployeeId(employeeId);
		employee.setReimbursement(reimbursements);
		return employee;
	}

}
