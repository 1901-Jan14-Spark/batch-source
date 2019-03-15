package com.revature.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.company.Department;
import com.revature.dao.DepartmentDao;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();

		String sql = "SELECT * FROM DEPARTMENTS";

		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {

			while (rs.next()) {
				int deptId = rs.getInt("DEPT_ID");
				String name = rs.getString("DEPT_NAME");
				int managerId = rs.getInt("DEPT_MANG");
				departments.add(new Department(deptId, name, managerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	@Override
	public Department getDepartmentById(int id) {
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPT_ID = ?";
		Department d = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int deptId = rs.getInt("DEPT_ID");
				String name = rs.getString("DEPT_NAME");
				int deptMang = rs.getInt("DEPT_MANG");
				d = new Department(deptId, name, deptMang);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return d;
	}

	@Override
	public Department getDepartmentByName(String name) {
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPT_NAME = ?";
		Department d = null;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int deptId = rs.getInt("DEPT_ID");
				String deptName = rs.getString("DEPT_NAME");
				int deptMang = rs.getInt("DEPT_MANG");
				d = new Department(deptId, deptName, deptMang);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return d;
	}
}
