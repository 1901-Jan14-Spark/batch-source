package com.revature.dao;

import java.util.List;

import com.revature.company.Department;

public interface DepartmentDao {
	
	public List<Department> getAllDepartments();
	public Department getDepartmentById(int id);
	public Department getDepartmentByName(String name);

}
