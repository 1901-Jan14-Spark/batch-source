package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.ReimburstmentClient;
import com.revature.models.Employee;
import com.revature.models.Reimburstment;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private Logger log = Logger.getLogger(EmployeeController.class);
	
	private List<Employee> employees = new ArrayList<>();
	
	@Autowired
	ReimburstmentClient reclient;
	
	public EmployeeController()
	{
		super();
		employees.add(new Employee(1, "Bob", "happy@little.trees", null));
		employees.add(new Employee(2, "Leeroy", "atleast@igot.chicken", null));
		employees.add(new Employee(3, "Zero Wing", "allyourbase@arebelong.tous", null));
	}
	
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		log.info("getting all employees");
		return employees;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId)
	{
		log.info("getting customer by id: " + employeeId);
		Employee employee = employees.stream()
				.filter(empl -> empl.getEmployeeId()==employeeId)
				.findFirst().get();
		List<Reimburstment> reimburstments = reclient.getReimburstmentsByEmployeeId(employeeId);
		employee.setReimburstments(reimburstments);
		return employee;
	}
}
