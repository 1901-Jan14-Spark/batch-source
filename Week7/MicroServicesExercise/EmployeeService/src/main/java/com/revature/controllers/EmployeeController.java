package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.ReimburseClient;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private List<Employee> employees = new ArrayList<>();
	
	@Autowired
	ReimburseClient reimburseClient;
	
	public EmployeeController() {
		super();
		employees.add(new Employee(1, "Bent Crumley", "	bcrumley0@ebay.co.uk", null));
		employees.add(new Employee(2, "Pansy Aistrop", "paistrop1@engadget.comm", null));
		employees.add(new Employee(3, "Nerita Peel", "npeel2@harvard.edu", null));
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employees;
	}
	
	@GetMapping("/{empId}")
	public Employee getEmployeeById(@PathVariable("empId")Integer empId) {
		Employee employee = employees.stream().filter(emp -> emp.getEmpId()==empId).findFirst().get();
		List<Reimbursement> reimbursements = reimburseClient.getReimbursementsByEmpId(empId);
		employee.setReimbursements(reimbursements);
		return employee;
	}
}