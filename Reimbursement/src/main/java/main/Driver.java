package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import models.Employees;
import util.ConnectionUtil;

public class Driver {
	
	
	public static void main(String[] args) {
		
//		try {
//			Connection c = ConnectionUtil.systemVar();
//			System.out.println(c.getMetaData().getDriverName());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
		
		EmployeesDao ed1 = new EmployeesDaoImpl();
		 List<Employees> a = ed1.getEmployees();
		for(Employees e:a) {
			System.out.println(e);
		}
	
	}
		
	
	
}