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
				int accNum = rs.getInt("ACC_NUM");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");

				clients.add(new BankClients(accNum, firstname, lastname, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public BankClients getClientById(int accID) {
		BankClients bc = null;
		String sql = "SELECT * FROM BANK_CLIENTS WHERE ACC_NUM = ?";
		try(Connection con = ConnectionUtil.sysVar(); 
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, accID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int accNum = rs.getInt("ACC_NUM");
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
		String sql = "INSERT INTO BANK_CLIENTS VALUES(?,?,?,?,?,?)";
		int clientsCreated = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, bc.getAccID());
			ps.setString(2, bc.getFirstName());
			ps.setString(3, bc.getLastName());
			ps.setString(4, bc.getEmail());
			ps.setString(5, bc.getUsername());
			ps.setString(6, bc.getPassword());
			clientsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsCreated;
	}

	@Override
	public int updateClient(BankClients bc) {
		String sql = "UPDATE BANK_CLIENTS SET FIRSTNAME= ?, LASTNAME= ?,EMAIL=? WHERE ACC_NUM= ?";
		int clientsUpdated = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, bc.getFirstName());
			ps.setString(2, bc.getLastName());
			ps.setString(3, bc.getEmail());
			ps.setInt(4, bc.getAccID());
			clientsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsUpdated;
	}

	@Override
	public int deleteClient(int accID) {
		String sql = "DELETE FROM BANK_CLIENTS WHERE ACC_NUM =?";
		int rowsDeleted = 0;
		try(Connection con = ConnectionUtil.sysVar();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, accID);
			rowsDeleted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsDeleted;
	}

	@Override
	public boolean validation(String userName, String passWord) {
		boolean match = false;
		String sql = "SELECT USERNAME, PASSWORD FROM BANK_CLIENTS";
		try(Connection con = ConnectionUtil.sysVar(); 
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				if(username.equals(userName) && password.equals(passWord)) {
						match = true;
}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return match;
		
	}

	

}
