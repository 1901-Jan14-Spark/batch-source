package junit;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import dao.ReimbursementsDao;
import dao.ReimbursementsDaoImpl;
import models.Employees;
import models.Reimbursements;
public class Tests {

	EmployeesDao ed = new EmployeesDaoImpl(); 
	ReimbursementsDao rd = new ReimbursementsDaoImpl();

	@Test
	public void upReim() {
		boolean result;
		Reimbursements a = rd.getReimById(1010);
		a.setReimStatus("APPROVED");
		a.setResolvedId(1);
		int c = rd.updateReims(a);
		System.out.println(a);
		if(c == 1) {
			result = true;
		}else {
			result = false;
		}
		assertEquals(true, result);
	}

	@Test
	public void manaLogin() {
		boolean isManager;
		Employees employee = ed.getEmployeesById(1);
		System.out.println(employee.getUsername());
		System.out.println(employee.getPassword());
		System.out.println(employee.IsMana());

				if("August1126".equals(employee.getUsername()) && "Jar1126".equals(employee.getPassword()) && employee.IsMana()==1) {
					isManager = true;
		}else {
			isManager = false;
		}
		assertEquals(true, isManager);
	}
	
	@Test
	public void empLogin() {
		boolean isEmp;
		Employees employee = ed.getEmployeesById(3);
		System.out.println(employee.getUsername());
		System.out.println(employee.getPassword());
		System.out.println(employee.IsMana());

				if("pshriver".equals(employee.getUsername()) && "passpass".equals(employee.getPassword()) && employee.IsMana()==0) {
					isEmp = true;
		}else {
			isEmp = false;
		}
		assertEquals(true, isEmp);
	}
}
