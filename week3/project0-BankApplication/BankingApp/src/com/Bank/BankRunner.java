package com.Bank;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.Bank.BankController;
import com.Bank.BankView;
import com.Bank.User;

public class BankRunner {
	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//log.debug("Log4j appender configuration is successful ! - controller");
		BankController theController = new BankController();

		// Log in console in and log file

		// UserDAO dd = new DepartmentDaoImpl();
//	List<Department> departments = dd.getDepartments();
//	for(Department d: departments) {
//		System.out.println(d);

//   Connection c;
//try {
//	c = ConnectionUtil.getConnection();
//	 System.out.println(c.getMetaData().getDriverName());
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//  

		UserDAO x = new UserDaoImp();
		List<User> users = x.getusers();

		for (User y : users) {

			System.out.println(y);

		}

	}

}
