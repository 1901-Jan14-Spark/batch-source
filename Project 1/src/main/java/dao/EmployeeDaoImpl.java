package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.Employee;
import util.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public List<Employee> retrieveEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	//A implemented method that will access the SQL DB and check if the input username/password match any in the database.
	@Override
	public String loginCheck(String username, String password) {
		
		return null;
	}

	@Override
	public Employee getEmployeeByUsername(String emailInp) {
		String sql = "Select * From Employee Where Email = ?";
		Employee tempEmp = null;
		System.out.println("email input: "+emailInp);
		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, emailInp);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				if (Integer.valueOf(rs.getInt("REPORTSTO")) == null) {
					int reportsTo = 0;
				} else {
					int reportsTo = rs.getInt("REPORTSTO");
				}
				int loggedIn = rs.getInt("LOGGEDIN");
				tempEmp = new Employee(empId, fName, lName, email, password, loggedIn);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempEmp;
	}

}
