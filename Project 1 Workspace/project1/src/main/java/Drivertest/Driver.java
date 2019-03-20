package Drivertest;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;

public class Driver {
	
	public static void main(String[] args) {
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		EmployeeService es = new EmployeeService();
//		System.out.println(ed.getEmployees());
//		System.out.println(es.getAll());
//		String user = "djbogar";
//		String pass = "thispassword";
//		System.out.println(ed.getEmployeeBySignIn(user, pass));
//		System.out.println(ed.getEmployeeId(1));
//		System.out.println(es.getById(1));
		ReimbursementDaoImpl rd = new ReimbursementDaoImpl();
		ReimbursementService rs = new ReimbursementService();
//		System.out.println(rd.getReimbursements());
//		System.out.println(rs.getAll());
//		System.out.println(rd.getReimbursementsByEmpId(1));
//		rs.getPendingReimbursementsByEmpId(1);
		System.out.println(rd.getResolvedReimbursements());
	}
}
