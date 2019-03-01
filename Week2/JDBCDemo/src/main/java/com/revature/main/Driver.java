package com.revature.main;

import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.DepartmentDaoImpl;
import com.revature.model.Department;

public class Driver {

	public static void main(String[] args) {
		
		/*
		try {
			Connection c = ConnectionUtil.getConnection();
			System.out.println(c.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		*/
		
		DepartmentDao dd = new DepartmentDaoImpl();
		List<Department> departments = dd.getDepartments();
		for(Department d: departments) {
			System.out.println(d);
		}

	}

}
