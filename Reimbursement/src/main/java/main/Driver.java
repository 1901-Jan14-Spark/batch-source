package main;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import dao.ReimbursementsDao;
import dao.ReimbursementsDaoImpl;
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
		ReimbursementsDao reims = new ReimbursementsDaoImpl();
		Reimbursements a = reims.getReimById(1003);
		a.setReimStatus("Approved");
		a.setResolvedId(1);
		int updated = reims.updateReims(a);
		System.out.println(updated);
//	EmployeesDao ed = new EmployeesDaoImpl();
//		ReimbursementsDao rd = new ReimbursementsDaoImpl();
//		Reimbursements a = rd.getReimById(1000);
//		a.setReimStatus("DENIED");
//		a.setResolvedId(1);
//		int updated = rd.updateReims(a);
//		System.out.println(updated);
	}
		
	
	
 }