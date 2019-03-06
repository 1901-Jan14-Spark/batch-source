package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.BankClients;
import util.ConnectionUtil;

public class BankClientsDaoImpl implements BankClientsDao {

	@Override
	public List<BankClients> getClients() {
		List<BankClients> clients = new ArrayList<>();
		String sql = "SELECT * FROM BANK_CLIENTS";
		try(Connection con = ConnectionUtil.sysVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int memNum = rs.getInt("MEM_NUM");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");

				clients.add(new BankClients(memNum, firstname, lastname, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public BankClients getClientById(int memNum) {
		BankClients bc = null;
		String sql = "SELECT * FROM BANK_CLIENTS WHERE MEM_NUM = ?";
		try(Connection con = ConnectionUtil.sysVar(); 
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, memNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accNum = rs.getInt("MEM_NUM");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");

				bc = new BankClients(accNum, firstname, lastname, email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bc;
		
	}

	@Override
	public int createClient(BankClients bc) {
		String sql = "INSERT INTO BANK_CLIENTS VALUES(null,?,?,?,?,?)";
		int clientsCreated = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, bc.getFirstName());
			ps.setString(2, bc.getLastName());
			ps.setString(3, bc.getEmail());
			ps.setString(4, bc.getUsername());
			ps.setString(5, bc.getPassword());
			clientsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsCreated;
	}

	@Override
	public int updateClient(BankClients bc) {
		String sql = "UPDATE BANK_CLIENTS SET FIRSTNAME= ?, LASTNAME= ?,EMAIL=? WHERE MEM_NUM= ?";
		int clientsUpdated = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, bc.getFirstName());
			ps.setString(2, bc.getLastName());
			ps.setString(3, bc.getEmail());
			ps.setInt(4, bc.getMemNum());
			clientsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsUpdated;
	}

	@Override
	public int deleteClient(int memNum) {
		String sql = "DELETE FROM BANK_CLIENTS WHERE MEM_NUM =?";
		int rowsDeleted = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, memNum);
			rowsDeleted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public boolean validation(String userName, String passWord) {
        boolean match = false;
		String sql = "SELECT * FROM BANK_CLIENTS WHERE USERNAME = ? AND PASSWORD =?";
		try(Connection con = ConnectionUtil.sysVar(); 
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				if(username.equals(userName) && password.equals(passWord)) {
						match= true;
					}
				} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return match;
		
	}

	@Override
	public String user(String firstname, String Lastname) {
		String sql = "SELECT (FIRSTNAME|| ' ' || LASTNAME) FROM BANK_CLIENTS";
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sql;
	}

	

}
