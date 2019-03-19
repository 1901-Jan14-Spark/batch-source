package com.revature.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.util.Connections;

public class ManagerDAO_Impl implements ManagerDAO{

	@Override
	public Manager varifyAccount(String username, String password) {
		String sql = "SELECT * FROM MANAGERS WHERE USERNAME = ? AND PASSWORD= ?";
		Manager mng = null;
		
		try(Connection con = Connections.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("EMP_ID");
				System.out.println(Id);
				String wholeName= rs.getString("EMP_NAME");
//				Date birthday = rs.getDate("BIRTHDAY");
				int salary = rs.getInt("MONTHLY_SALARY");

				String position=rs.getString("POSITION");
				int reportsto = rs.getInt("MANAGER_ID");
//				Date hireDate = rs.getDate("HIRE_DATE");
				String name = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				System.out.println("username"+ name);
				
				
				mng = new Manager(Id, wholeName, "1998-02-12", salary, position, reportsto, "1996-02-02", name, pass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("threw exception");
		}catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("IO exception");
		}catch (IllegalStateException e2) {
			e2.printStackTrace();
			System.out.println("IO exception");
		}
		
		return mng;

	}

}
