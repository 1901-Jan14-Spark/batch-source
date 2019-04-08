package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.ReimbursementClient;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> employees = new ArrayList<>();

	@Autowired
	ReimbursementClient reimbursementClient;
	
	public EmployeeController() {
		super();
		employees.add(new Employee(1, "magikarp", null));
		employees.add(new Employee(2, "gyrados", null));
		employees.add(new Employee(3, "pikachu", null));
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		for(Employee e: employees) {
			List<Reimbursement> reimbursements = reimbursementClient.getReimbursementsByEmployeeId(e.getEmployeeId());
			e.setReimbursements(reimbursements);
		}
		return employees;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		Employee employee = employees.stream().filter(emp -> emp.getEmployeeId() == employeeId).findFirst().get();
		List<Reimbursement> reimbursements = reimbursementClient.getReimbursementsByEmployeeId(employeeId);
		employee.setReimbursements(reimbursements);
		return employee;
	}
}