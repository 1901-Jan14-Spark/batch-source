package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import intercom.ReimburseClient;
import models.Employee;
import models.Reimbursement;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employees = new ArrayList<>();
	
	@Autowired
	ReimburseClient reimburseClient;
	
	public EmployeeController() {
		super();
		employees.add(new Employee(1, "Martha Wayne",null ));
		employees.add(new Employee(2, "Martha Kent", null));
		employees.add(new Employee(3, "Jeff Ross", null));
		employees.add(new Employee(4, "Tim Drake", null));
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId")Integer employeeId) {
		Employee employee = employees.stream().filter(emp-> emp.getEmployeeId()==employeeId).findFirst().get();
		List<Reimbursement> reimbursements = reimburseClient.getReimbursementByEmployeeId(employeeId);
		employee.setReimbursements(reimbursements);
		return employee;
	}
}
