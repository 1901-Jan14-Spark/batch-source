package com.revature.dao.im;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	
	List<Employee>  emp =  new ArrayList<>();
	Employee em = new Employee();
	
	
	public Employee getEmployeeByUsername(String username) {

		
       
	//	String sql = "select * from employee where firstname = ? ";
		String sql = "select * from employeeANDprofile where username = ? ";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("EID");
				em.setId(userId);
				String firstName = rs.getString("FIRSTNAME");
				em.setFirsName(firstName);
				String lastName = rs.getString("LASTNAME");
				em.setLastName(lastName);
				String email = rs.getString("EMAIL");
				em.setEmail(email);
				int salary = rs.getInt("SALARY");
			//	em.setSalary(salary);
				Date hiredate = rs.getDate("HIREDATE");
				em.setHireDate(hiredate);
				String password = rs.getString("PASSWORD");
				
		        em.getProfile().setPassword(password);
		       
		        
				em.getProfile().setUserName(username);
				
           
			// AccountDaoImp.setAccountDetailforObject(user, userId);

				//

			}
			//AccountDaoImp.setAccountDetailforObject(user, user.getID());
		
			return em;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployeeById(int id) {


		
	       
		//	String sql = "select * from employee where firstname = ? ";
			String sql = "select * from employeeANDprofile where EID = ? ";

			try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int userId = rs.getInt("EID");
					em.setId(userId);
					String firstName = rs.getString("FIRSTNAME");
					em.setFirsName(firstName);
					String lastName = rs.getString("LASTNAME");
					em.setLastName(lastName);
					String email = rs.getString("EMAIL");
					em.setEmail(email);
					BigDecimal salary = rs.getBigDecimal("SALARY");
					em.setSalary(salary);
					Date hiredate = rs.getDate("HIREDATE");
					em.setHireDate(hiredate);
					String password = rs.getString("PASSWORD");
					int TId = rs.getInt("TID");
					em.getTitle().setTitleID(TId);
					
					if(TId == 1) {
						em.getTitle().setTitle("Manager");
					}
					else {
						em.getTitle().setTitle("Employee");
					}
					
	                 em.getProfile().setPassword(password);
			       
			        String userName = rs.getString("PASSWORD");
					em.getProfile().setUserName(userName);
					
	           
				// AccountDaoImp.setAccountDetailforObject(user, userId);

					//

				}
				//AccountDaoImp.setAccountDetailforObject(user,  user.getID());
				System.out.println("printing employee from daoi" + em );

				return em;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;

		
	}

	public int createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
	
}
