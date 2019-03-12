package com.revature.service;

import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.im.DepartmentDaoImpl;
import com.revature.model.Department;

public class DepartmentService implements CrudService<Department> {
	
	DepartmentDao deptDao = new DepartmentDaoImpl();
	
	public List<Department> getAll(){
		return deptDao.getDepartments();
	}

	public Department getById(int id) {
		return deptDao.getDepartmentById(id);
	}
	
	public int create(Department department) {
		return deptDao.createDepartment(department);
	}
	
	public int update(Department department) {
		return deptDao.updateDepartment(department);
	}
	
	public int deleteById(int id) {
		return deptDao.deleteDepartmentById(id);
	}
	
}
