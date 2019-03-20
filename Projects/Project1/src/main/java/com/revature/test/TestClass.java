package com.revature.test;

import java.util.List;

import com.revature.company.Department;
import com.revature.company.Employee;
import com.revature.services.DepartmentService;
import com.revature.services.EmployeeService;

public class TestClass {

	public static void main(String[] args) {
		
//		try {
//			Connection c = ConnectionUtil.getConnection();
//			System.out.println(c.getMetaData());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		EmployeeService es = new EmployeeService();
		List<Employee> employees = es.getAll();
		for(Employee e : employees) {
			System.out.println(e);
		}
		
		DepartmentService ds = new DepartmentService();
		List<Department> departments = ds.getAll();
		for(Department d : departments) {
			System.out.println(d);
		}
	}

}
