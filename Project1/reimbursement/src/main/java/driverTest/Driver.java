package driverTest;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmpDao;
import dao.EmpDaoImpl;
import model.EmpObj;
import util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		EmpDao ed = new EmpDaoImpl();
		int userId = 102;
		String pass = "guest1";
		EmpObj credential = ed.getIdAndPass(userId);
		int storedId = credential.geteId();
		String storedPass = credential.getePass();
		
		if(userId == storedId && pass.equals(storedPass))
			System.out.println("true");
		
		else
			System.out.println("false");
	}

}
