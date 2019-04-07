package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.ReimbursementsClient;
import com.revature.models.Employees;
import com.revature.models.Reimbursements;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employees> employees = new ArrayList<>();
	private Logger log = Logger.getLogger(EmployeeController.class);
	@Autowired
	ReimbursementsClient reimClient;
	
	
	public EmployeeController() {
		super();
		employees.add(new Employees(1, "Tyson Mackmara", null));
		employees.add(new Employees(2, "Terry The T-rex", null));
		employees.add(new Employees(3, "Alltein Sherbert", null));

	}

	
	@GetMapping
	public List<Employees> getAllEmps(){
		log.info("getting all employees");
		return employees;
	}
	
	@GetMapping("/{customerId}")
	public Employees getEmpById(@PathVariable("empId")Integer empId) {
		log.info("getting employees by id:" + empId);
		Employees employee = employees.stream()
				.filter(cust -> cust.getEmpId()==empId)
				.findFirst().get();
		List<Reimbursements> reims = reimClient.getReimsByEmpId(empId);
		employee.setReims(reims);
		return employee;
	}
	
}
