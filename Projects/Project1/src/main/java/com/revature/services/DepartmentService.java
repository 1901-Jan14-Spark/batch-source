package com.revature.services;

import java.util.List;

import com.revature.company.Department;
import com.revature.dao.DepartmentDao;
import com.revature.dao.imp.DepartmentDaoImpl;

public class DepartmentService {

	DepartmentDao dDao = new DepartmentDaoImpl();
	
	public List<Department> getAll() {	
		return dDao.getAllDepartments();
	}

	public Department getById(int id) {
		return dDao.getDepartmentById(id);
	}

	public Department getByName(String name) {
		return dDao.getDepartmentByName(name);	
	}


}
