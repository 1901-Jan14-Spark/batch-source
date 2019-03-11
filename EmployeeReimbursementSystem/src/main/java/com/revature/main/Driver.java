package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.utility.ConnectionUtil;

@SuppressWarnings("unused")
public class Driver {

	public static void main(String[] args) {
		
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			System.out.println(con.getMetaData().getDriverName());
//		} catch (SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		
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
