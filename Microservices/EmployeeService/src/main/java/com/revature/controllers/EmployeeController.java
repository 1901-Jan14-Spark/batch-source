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
import com.revature.models.Reimbursements;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private Logger logger = Logger.getLogger(EmployeeController.class);
	
	private List<Employee> emps = new ArrayList<>();
	
	@Autowired
	ReimbursementClient reimbursementClient;
	
	public EmployeeController() {
		super();
		emps.add(new Employee(1, "Brenda", "Hystrix", null));
		emps.add((new Employee(2, "Thomas", "Spring", null)));
		emps.add((new Employee(3, "Erick", "Yml", null)));
		
	}
	
	@GetMapping
	public List<Employee> getEmployees(){
		logger.info("grabbing employees....");
		return emps;
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id")Integer id) {
		logger.info("getting employees by id yeeehaw");
		Employee emp = emps.stream().filter(empy -> empy.getId()==id).findFirst().get();
		List<Reimbursements> reimbys = reimbursementClient.getReimbursementsById(id);
		emp.setReimbursements(reimbys);
		return emp;
	}
}
