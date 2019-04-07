package com.revature.controllers;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.ReimburseClient;
import com.revature.models.Reimbursement;
import com.revature.models.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private Logger log = Logger.getLogger(EmployeeController.class);
	
	private List<Employee> employees = new ArrayList<>();
	
	@Autowired
	ReimburseClient ReimbursementClient;
	
	public EmployeeController() {
		super();
		employees.add(new Employee(1, "Youness Wardaoui", "w.youness@gmail.com", null));
		employees.add(new Employee(2, "jackson Em", "william@aol.com", null));
		employees.add(new Employee(3, "Ronald J.r", "RonaldJr@msn.com", null));
	}
	
	@GetMapping
	public List<Employee> getAllemployees(){
		log.info("getting all employees");
		return employees;
	}
	
	@GetMapping("/{EmployeeId}")
	public Employee getEmployeeById(@PathVariable("EmployeeId")Integer EmployeeId) {
		log.info("getting Employee by id:" + EmployeeId);
		Employee Employee = employees.stream()
				.filter(emp -> emp.getEmployeeId()==EmployeeId)
				.findFirst().get();
		List<Reimbursement> Reimbursements = ReimbursementClient.getReimbursementsByEmpId(EmployeeId);
		Employee.setReimbursements(Reimbursements);
		return Employee;
	}

}
