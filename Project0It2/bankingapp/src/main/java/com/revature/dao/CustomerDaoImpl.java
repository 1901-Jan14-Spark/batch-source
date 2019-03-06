package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao {
	AccountDaoImpl ad = new AccountDaoImpl();
	public Customer getCustomerByEmail(String email) {
		String sql = "SELECT * FROM CUSTOMER WHERE EMAIL = ?";
		Customer c = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int cId = rs.getInt("C_ID");
				int aId = rs.getInt("A_ID");
				String fname = rs.getString("F_NAME");
				String lname = rs.getString("L_NAME");
				String eml = rs.getString("EMAIL");
				String pw = rs.getString("PASSWD");
				Account cAcc = ad.getAccountById(aId);
				c = new Customer(cId, aId, cAcc, fname, lname, eml, pw);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	public int createCustomer(Customer cust) {
		
		
		String sql = "{call CREATECUS(?,?,?,?,?)}";
		
		try(Connection con = ConnectionUtil.getConnection();
				CallableStatement cs = con.prepareCall(sql)){
			cs.setString(1, cust.getFirstname());
			cs.setString(2, cust.getLastname());
			cs.setString(3, cust.getEmail());
			cs.setString(4, cust.getPassword());
			cs.setInt(5, cust.getAid());
			cs.execute();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> clist = new ArrayList<Customer>();
		String sql = "SELECT * FROM CUSTOMER";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
						ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				int cId = rs.getInt("C_ID");
				int aId = rs.getInt("A_ID");
				String fname = rs.getString("F_NAME");
				String lname = rs.getString("L_NAME");
				String eml = rs.getString("EMAIL");
				String pw = rs.getString("PASSWD");
				Account cAcc = null;
				clist.add(new Customer(cId, aId, cAcc, fname, lname, eml, pw));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;
	}

}
