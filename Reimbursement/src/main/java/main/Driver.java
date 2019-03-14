package main;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import dao.ReimbursementsDao;
import dao.ReimbursementsDaoImpl;
import models.Employees;
import models.Reimbursements;

public class Driver {
	
	
	public static void main(String[] args) {
		
//		try {
//			Connection c = ConnectionUtil.systemVar();
//			System.out.println(c.getMetaData().getDriverName());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		
//	EmployeesDao ed = new EmployeesDaoImpl();
//	ed.createEmployee(new Employees("Javier","Rodriguez","August12641","Jar1126","1"));
//	ed.createEmployee(new Employees("Peter","Parker","pparker","spiderman","0"));
//	ed.createEmployee(new Employees("Peyton","Shriver","pshriver","passpass","0"));
	
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		Reimbursements a = rd.updateReims(1);
		
	}
		
	
	
 }