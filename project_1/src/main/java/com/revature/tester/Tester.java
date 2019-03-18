package com.revature.tester;

import com.revature.utils.InputValidator;

public class Tester {

	public static void main(String[] args) {
		System.out.println(InputValidator.validateEmail("newEmail@gmail.com"));
//		EmployeeDao ed = new EmployeeDaoImplementation();

		/*
		 * Tester: getEmployees List<Employee> employeeList = ed.getEmployees();
		 * 
		 * for(Employee e : employeeList) { System.out.println(e); }
		 */

		/*
		 * Tester: getEmployeeById Employee e1 = ed.getEmployeeById(100000011);
		 * System.out.println(e1);
		 */

		/*
		 * Tester: getEmployeeByEmail Employee e2 =
		 * ed.getEmployeeByEmail("cweakleyb@shinystat.com"); System.out.println(e2);
		 */

		/*
		 * Tester: CreateEmployee Employee e3 = new Employee("myEmail@gmail.com",
		 * "random", "fname", "lname", 0); System.out.println(ed.createEmployee(e3));
		 */

		/*
		 * Tester: UpdateEmployee Employee e4 =
		 * ed.getEmployeeByEmail("myEmail@gmail.com"); System.out.println(e4);
		 * e4.setEmail("MyEmail2@gmail.com"); System.out.println(ed.updateEmployee(e4));
		 */

//		ReimbursementDao rd = new ReimbursementDaoImplementation();

		/*
		 * Tester: CreateReimbursement Reimbursement r1 = new Reimbursement(100000011,
		 * 25, "Title", "Description", null);
		 * System.out.println(rd.createReimbursement(r1));
		 */

		/*
		 * Tester: getReimbursements List<Reimbursement> reimbursements =
		 * rd.getReimbursements(); for(Reimbursement r : reimbursements) {
		 * System.out.println(r); }
		 */

		/*
		 * Tester: getReimbursementsFromEmployeeId List<Reimbursement> reimbursements =
		 * rd.getReimbursementsFromEmployeeId(100000011); for (Reimbursement r :
		 * reimbursements) { System.out.println(r); }
		 */

		/*
		 * Reimbursement r1 = rd.getReimbursementById(400000000);
		 * System.out.println(r1); r1.setAmount(r1.getAmount()+1);
		 * System.out.println(r1); System.out.println(rd.updateReimbursement(r1));
		 * Reimbursement r2 = rd.getReimbursementById(400000000);
		 * System.out.println(r2);
		 */

//		
//		  EmployeeService es = new EmployeeService(); 
//		  Employee es1 = es.getEmployeeByEmail("test.email@gmail.com"); 
//		  es1.setManagerLevel(1);
//		  System.out.println(es.getEmployees());
//		 
		 

	}
}
