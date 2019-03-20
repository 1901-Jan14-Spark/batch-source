package driver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import daos.EmployeeDao;
import daos.EmployeeDaoImp;
import daos.Request;

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
//		tester.updatePassword("agilaydones", "854");
//		System.out.println(tester.checkManager());
		//System.out.println(tester.getIdbyMngUser("chaliburn17"));
//		List<Integer> test = tester.getIdbyMngUser("chaliburn17");
//		System.out.println(test);
//		List<Request> req = tester.getRequestById("chaliburn17");
//		System.out.println(req);
		System.out.println(tester.getEmpByUser("aspurr1e"));
		
	}
	
	
}
