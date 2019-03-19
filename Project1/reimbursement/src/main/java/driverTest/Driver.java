package driverTest;

import java.util.List;

import dao.EmpDao;
import dao.EmpDaoImpl;
import dao.ReqDao;
import dao.ReqDaoImpl;
import model.EmpObj;
import model.ReqObj;

public class Driver {

	public static void main(String[] args) {
		EmpDao ed = new EmpDaoImpl();
//		int userId = 102;
//		String pass = "guest1";
//		EmpObj credential = ed.getIdAndPass(userId);
//		int storedId = credential.geteId();
//		String storedPass = credential.getePass();
//		
//		if(userId == storedId && pass.equals(storedPass))
//			System.out.println("true");
//		
//		else
//			System.out.println("false");
		
		List<EmpObj> employees = ed.getAllEmp();
		for(EmpObj e : employees) {
			System.out.println(e);
		}
		
		System.out.println();
		
		List<EmpObj> managers = ed.getOnlyMan();
		for(EmpObj e : managers) {
			System.out.println(e);
		}
		
		System.out.println();
		
		ReqDao rd = new ReqDaoImpl();
		List<ReqObj> requests = rd.getAllReq();
		for(ReqObj r : requests) {
			System.out.println(r);
		}
	}

}
