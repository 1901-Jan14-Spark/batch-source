package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utility.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			System.out.println(con.getMetaData().getDriverName());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		
		
//		EmployeeDao edi = new EmployeeDaoImpl();
//		List<Employee> allEmployees = edi.getEmployees(); 
//		System.out.println(allEmployees.size() + " employees");
//		for (Employee e: allEmployees) {
//			System.out.println(e);
//		}
		
		
//		RequestDao rdi = new RequestDaoImpl();
//		// List<Request> allRequests = rdi.getRequests();
//		List<Request> allRequests = rdi.getRequestsByEmployeeId(5);
//		for (Request r: allRequests) {
//			System.out.println(r);
//		}
		
		
//		ManagerDao mdi = new ManagerDaoImpl();
//		List<Manager> allManagers = mdi.getManagers();
//		System.out.println(allManagers.size() + " managers");
//		for (Manager m: allManagers) {
//			System.out.println(m);
//		}
		
		
	}

}
