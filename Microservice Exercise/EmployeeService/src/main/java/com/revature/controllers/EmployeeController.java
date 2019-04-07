package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;

import intercomm.ReimburesementClient;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
private Logger log = Logger.getLogger(EmployeeController.class);
	
	private List<Employee> employees = new ArrayList<>();
	

	@Autowired
	ReimburesementClient reimbursementClient;
	
	public EmployeeController() {
		employees.add(new Employee(1,"Stuart King", "Sales", null));
		employees.add(new Employee(2,"Frank Castle", "Reimbursementing", null));
		employees.add(new Employee(3,"Steve Rodgers", "HR", null));
		employees.add(new Employee(4,"Tony Stark", "Manager", null));
		employees.add(new Employee(5,"Matt Murdock", "Sales", null));
		employees.add(new Employee(6,"Danny Rand", "Reimbursementing", null));
	}

	@GetMapping
	public List<Employee> getAllEmployeess(){
		log.info("getting all employees");
		return employees;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId")Integer employeeId) {
		log.info("getting customer by id:" + employeeId);
		Employee employee = employees.stream()
				.filter(emp -> emp.getEmpId()==employeeId)
				.findFirst().get();
		List<Reimbursement> reimbursements = reimbursementClient.getReimbursmentByEmpId(employeeId);
		employee.setReimbursements(reimbursements);
		return employee;
	}

}
