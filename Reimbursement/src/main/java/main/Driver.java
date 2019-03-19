package main;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;

public class Driver {
	
	
	public static void main(String[] args) {
		
//		try {
//			Connection c = ConnectionUtil.systemVar();
//			System.out.println(c.getMetaData().getDriverName());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		
	EmployeesDao ed = new EmployeesDaoImpl();
//	ed.createEmployee(new Employees("Javier","Rodriguez","August12641","Jar1126","1"));
//	ed.createEmployee(new Employees("Peter","Parker","pparker","spiderman","0"));
//	ed.createEmployee(new Employees("Peyton","Shriver","pshriver","passpass","0"));
	System.out.println(ed.getAll());
//		ReimbursementsDao rd = new ReimbursementsDaoImpl();
//		Reimbursements a = rd.getReimById(1000);
//		a.setReimStatus("DENIED");
//		a.setResolvedId(1);
//		int updated = rd.updateReims(a);
//		System.out.println(updated);
	}
		
	
	
 }