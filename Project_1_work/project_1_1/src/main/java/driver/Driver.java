package driver;

import daos.EmployeeDao;
import daos.EmployeeDaoImp;

public class Driver {

	public static void main(String[] args) {
		EmployeeDaoImp tester = new EmployeeDaoImp();
		 
		System.out.println(tester.getEmployeeCredentials());
		System.out.println("Hello?");
		
		System.out.println(tester.getManager("nskeen2e"));
	}
	
	
}
