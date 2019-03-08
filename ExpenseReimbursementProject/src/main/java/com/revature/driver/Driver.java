package com.revature.driver;

import java.util.List;

import com.revature.daoImplementations.EmployeeDaoImpl;
import com.revature.daoImplementations.ReimbursementDaoImpl;
import com.revature.daos.EmployeeDao;
import com.revature.daos.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public class Driver {

	public static void main(String[] args) {
	
		EmployeeDao ed = new EmployeeDaoImpl();
//		List<Employee> employeeList = ed.getEmployees();
//		for(Employee e : employeeList) {
//			System.out.println(e);
//		}
		
//		List<Employee> employeeList = ed.getEmployees();
//		for(Employee e : employeeList) {
//			System.out.println(e);
//		}
		
//		Employee eTest = ed.getEmployee(new Employee(300000020));
//		System.out.println(eTest);
//		
//		Employee eTest2 = ed.getEmployeeByEmail("lcuskeryb@parallels.com");
//		System.out.println(eTest2);
		
//		int isCreated = ed.createEmployee("email@gmail.com", "TestPass",300000031 );
//		System.out.println(isCreated);
//		Employee e = ed.getEmployeeByEmail("email@gmail.com");
//		e.setFirstname("Mike");
//		e.setLastname("Norton");
//		e.setPassword("password");
//		System.out.println(ed.updateEmployeeInfo(e));
//		ed.upgradeToManager(e);
		ReimbursementDao rd = new ReimbursementDaoImpl();
//		List<Reimbursement> reimbursementList = rd.getReimbursementsPending();
//		for(Reimbursement r : reimbursementList) {
//			System.out.println(r);
//		}
		Reimbursement r = rd.getReimbursement(new Reimbursement(400000001));
		r.setDescription("Updated Reimbursement");
		System.out.println(rd.updateReimbursement(r));
	}

}
