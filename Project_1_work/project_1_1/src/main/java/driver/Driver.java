package driver;

import daos.EmployeeDao;
import daos.EmployeeDaoImp;

public class Driver {

	public static void main(String[] args) {
		EmployeeDao tester = new EmployeeDaoImp();
		 
		System.out.println(tester.getEmployeeCredentials());
	}
	
	
}
