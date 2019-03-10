package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Employees;
import util.ConnectionUtil;

public class EmployeesDaoImpl implements EmployeesDao{

	@Override
	public List<Employees> getEmployees() {
		String sql = "SELECT * FROM EMPLOYEES WHERE IS_MANA =0";
		List<Employees> emp = new ArrayList<>();
		try(Connection con = ConnectionUtil.systemVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String username =rs.getString("EMP_USER");
				String password = rs.getString("EMP_PASS");
				String isMana = rs.getString("IS_MANA");
				emp.add(new Employees(id,first,last,username, password, isMana));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	

	@Override
	public List<Employees> getManagers() {
		String sql = "SELECT * FROM EMPLOYEES WHERE IS_MANA =1";
		List<Employees> emp = new ArrayList<>();
		try(Connection con = ConnectionUtil.systemVar();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				int id = rs.getInt("EMP_ID");
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String username =rs.getString("EMP_USER");
				String password = rs.getString("EMP_PASS");
				String isMana = rs.getString("IS_MANA");
				emp.add(new Employees(id,first,last,username, password, isMana));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;

	}
}
