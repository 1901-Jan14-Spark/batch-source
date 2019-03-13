package driver;

import java.sql.Connection;
import java.sql.SQLException;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import models.Employee;
import util.DBConnection;

public class TestDriver {

	public static void main(String[] args) {
		try {
			Connection c = DBConnection.getConnection();
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println();
		
		
		EmployeeDao empDao = new EmployeeDaoImpl();
		Employee test = empDao.getEmployeeByUsername("vksadanani@gmail.com");
		System.out.println(test.getFirstName());
	}

}

