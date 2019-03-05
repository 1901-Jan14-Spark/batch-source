package com.rev.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
	static int id = 0;
	static HashMap<String,String> creds= new HashMap<String, String>();
	public List<Customer> getCustomers() {
		 List<Customer> customers = new ArrayList<>();
		 
		 String sql = "SELECT * FROM C_USERS";
		 try(Connection con = ConnectionSrc.getConnection();
				 Statement s = con.createStatement();
				 ResultSet rs = s.executeQuery(sql);){
			 while(rs.next()) {
				// int cusId = rs.getInt("CUSTOMER_ID");
				 String name = rs.getString("CUSTOMER_NAME");
				 String pass = rs.getString("PASSWORD");
				 String username = rs.getString("USERNAME");
				 double bal = rs.getDouble("BALANCE");
				 customers.add(new Customer(name, bal, username, pass)); 
			 }
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}
	
	public Customer getCustomerById(int id) {

		Customer c = new Customer();
		String sql = "SELECT * FROM C_USERS WHERE CUSTOMER_ID = ?";
		try(Connection con = ConnectionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						//int cusId = rs.getInt("CUSTOMER_ID");
						String name = rs.getString("CUSTOMER_NAME");
						double bal = rs.getDouble("BALANCE");
						String userN = rs.getString("USERNAME");
						
						c = new Customer(name,bal, userN);
					}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public int addCustomer(Customer c) {
		int customersAdded = 0;
		String sql = "INSERT INTO C_USERS (CUSTOMER_NAME,BALANCE,USERNAME,PASSWORD)  VALUES (?,?,?,?)";
		try(Connection con = ConnectionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
				//ps.setInt(1,c.getID());
			 	ps.setString(1,c.getName());
			 	ps.setDouble(2,c.getBalance());
			 	ps.setString(3, c.getUsername());
			 	ps.setString(4,c.getPassword());
			 	
			 	customersAdded = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customersAdded;
	}

	public int updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	
	public HashMap<String,String> getCustomerCredentials() {

		String sql = "SELECT USERNAME, PASSWORD FROM C_USERS";
		try(Connection con = ConnectionSrc.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			 	while(rs.next()) {
			 		String pass = rs.getString("USERNAME");
			 		String user = rs.getString("PASSWORD");
			 		creds.put(pass, user);
			 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		// TODO Auto-generated method stub
		return creds;
	}

	
	
	
	@Override
	public double getBalance(int id) {
		double bal = 0;
		String sql = "SELECT BALANCE FROM C_USERS WHERE CUSTOMER_ID = ?";
		try(Connection con = ConnectionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			 	ps.setInt(1,id);
			 	ResultSet rs = ps.executeQuery();
			 	while(rs.next()) {
			 		 bal = rs.getDouble("BALANCE");
			 	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bal;
	}

	@Override
	public int getIdByname(String name) {
		
		int id = 0;
		String sql ="SELECT CUSTOMER_ID FROM C_USERS WHERE CUSTOMER_NAME = ?";
		try(Connection con = ConnectionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			 	ps.setString(1,name);
			 	ResultSet rs = ps.executeQuery();
			 	while(rs.next()) {
			 		id = rs.getInt("CUSTOMER_ID");
			 	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return id;
	}
	
	
	
	

	@Override
	public void changeCustomerBalance(int id, double changeAmount) {
		
		String sql= "UPDATE C_USERS SET BALANCE = ? WHERE CUSTOMER_ID = ?";
		try(Connection con = ConnectionSrc.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
				ps.setDouble(1, changeAmount);
				ps.setInt(2, id);
				ps.executeUpdate();
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int getIdByUser(String username) {
		int id = 0;
		String sql ="SELECT CUSTOMER_ID FROM C_USERS WHERE CUSTOMER_NAME = ?";
		try(Connection con = ConnectionSrc.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			 	ps.setString(1,username);
			 	ResultSet rs = ps.executeQuery();
			 	while(rs.next()) {
			 		id = rs.getInt("CUSTOMER_ID");
			 	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return id;
		
	}

}
