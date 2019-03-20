package com.revature.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;
public class EmployeeDaoJdbc implements EmployeeDao {

	@Override
	public Employee getEmployeeByEmail(String email) {
		String sql = "SELECT * FROM Employee WHERE EMAIL = ?";
		Employee e = null;
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int cId = rs.getInt("E_ID");
				boolean isM = (rs.getString("IS_MANAGER").contentEquals("Y"))? true: false;
				String fname = rs.getString("F_NAME");
				String lname = rs.getString("L_NAME");
				String phone = rs.getString("PHONE");
				String eml = rs.getString("EMAIL");
				String pw = rs.getString("PASSWD");
				e = new Employee(cId,isM, fname, lname,  phone, eml, pw);
			}
			
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> elist = new ArrayList<Employee>();
		String sql = "SELECT * FROM Employee";
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
						ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				int cId = rs.getInt("E_ID");
				boolean isM = (rs.getString("IS_MANAGER").contentEquals("Y"))? true: false;
				String fname = rs.getString("F_NAME");
				String lname = rs.getString("L_NAME");
				String phone = rs.getString("PHONE");
				String eml = rs.getString("EMAIL");
				String pw = rs.getString("PASSWD");
				elist.add( new Employee(cId,isM, fname, lname, phone, eml, pw));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elist;
	}

	@Override
	public void createEmployee(Employee e) {
		String sql = "INSERT INTO EMPLOYEE VALUES (EMP_ID_SEQ.NEXTVAL,'N', ?, ?, ?, ?, ?)";
	
		
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, e.getfName());
			ps.setString(2, e.getlName());
			ps.setString(3, e.getPhone());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.executeQuery();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		return ;
		
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
	String sql = "UPDATE EMPLOYEE SET F_NAME = NVL(?,F_NAME), L_NAME = NVL(?,L_NAME) PHONE = NVL(?,PHONE), EMAIL = NVL(?,EMAIL), PASSWD = NVL(?,PASSWD) WHERE E_ID = ?";
	
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, e.getfName());
			ps.setString(2, e.getlName());
			ps.setString(3, e.getPhone());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.geteID());
			ps.executeQuery();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		
	}

}
