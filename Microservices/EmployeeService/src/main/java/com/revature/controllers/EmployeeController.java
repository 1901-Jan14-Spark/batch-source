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
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private Logger log = Logger.getLogger(EmployeeController.class);
	
	private List<Employee> employees = new ArrayList<>();

	@Autowired
	ReimbursementClient reimbursementClient;
	
	public EmployeeController() {
		super();
		employees.add(new Employee(1, "Harry Potter", null));
		employees.add(new Employee(2, "Hermione Granger", null));
		employees.add(new Employee(3, "Ron Weasley", null));
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		log.info("Retrieving all employees.");
		for(Employee e: employees) {
			List<Reimbursement> reimbursements = reimbursementClient.getReimbursementsByEmployeeId(e.getEmployeeId());
			e.setReimbursements(reimbursements);
		}
		return employees;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		log.info("Retrieving employee: "+ employeeId + ".");
		Employee employee = employees.stream().filter(emp -> emp.getEmployeeId() == employeeId).findFirst().get();
		List<Reimbursement> reimbursements = reimbursementClient.getReimbursementsByEmployeeId(employeeId);
		employee.setReimbursements(reimbursements);
		return employee;
	}
}