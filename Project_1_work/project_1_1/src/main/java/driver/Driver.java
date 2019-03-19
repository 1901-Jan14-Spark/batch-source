package driver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import daos.EmployeeDao;
import daos.EmployeeDaoImp;

public class Driver {

	public static void main(String[] args) {
		EmployeeDaoImp tester = new EmployeeDaoImp();
		 
		//System.out.println(tester.getEmployeeCredentials());
		System.out.println("Hello?");
		
		//System.out.println(tester.getManager("nskeen2e"));
		//System.out.println(tester.getEmpByUser("rjedrzejewski1j"));
		//System.out.println(tester.getManagerName("rjedrzejewski1j"));
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now));
//		System.out.println(tester.getRequests("gmarle1m"));
		tester.updatePassword("agilaydones", "854");
	}
	
	
}
