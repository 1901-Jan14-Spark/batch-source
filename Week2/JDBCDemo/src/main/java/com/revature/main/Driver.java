package com.revature.main;

import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoImpl;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class Driver {

	public static void main(String[] args) {
		
		/*
		try {
			Connection c = ConnectionUtil.getConnection();
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		*/
		
		DepartmentDao dd = new DepartmentDaoImpl();
//		List<Department> departments = dd.getDepartments();
//		for(Department d: departments) {
//			System.out.println(d);
//		}
//		
//		System.out.println();
//		System.out.println();
		
		
//		Department acctDept = dd.getDepartmentById(3);
//		System.out.println(acctDept);
		
//		System.out.println("Adding a new department");
//		int created = dd.createDepartment(new Department("ADVERTISING", 14000));
//		System.out.println(created);
//		
//		System.out.println();
//		System.out.println();
		
//		List<Department> departments2 = dd.getDepartments();
//		for(Department d: departments2) {
//			System.out.println(d);
//		}
		
//		Department d = dd.getDepartmentById(28);
//		d.setName("NOT ADVERTISING");
//		int updated = dd.updateDepartment(d);
//		System.out.println(updated);
		
//		int deleted = dd.deleteDepartment(28);
//		System.out.println(deleted);
		
		
//		Department d = dd.getDepartmentById(7);
//		dd.increaseDepartmentBudget(d, 3800);
		
		
		EmployeeDao ed = new EmployeeDaoImpl();
		List<Employee> employees = ed.getEmployees();
		for(Employee e : employees) {
			System.out.println(e);
		}
		
//		LocationDao ld = new LocationDaoImpl();
//		List<Location> locations = ld.getLocations();
//		for(Location l : locations) {
//			System.out.println(l);
//		}

	}

}
