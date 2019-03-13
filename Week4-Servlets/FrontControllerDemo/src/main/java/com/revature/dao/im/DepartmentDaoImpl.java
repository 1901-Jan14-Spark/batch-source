package com.revature.dao.im;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.model.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	
	List<Department> departments = new ArrayList<>();
	
	public DepartmentDaoImpl() {
		super();
		departments.add(new Department(1, "Human Resources", 13000));
		departments.add(new Department(2, "Information Technology", 15000));
		departments.add(new Department(3, "Sales", 12000));
//		departments.add(new Department(7, "Marketing", 15000));
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public Department getDepartmentById(int id) {
		for(Department d: departments) {
			if(d.getId() == id) {
				return d;
			}
		}
		return null;
	}

	public int createDepartment(Department department) {
		for(Department d: departments) {
			if(d.getId() == department.getId()) {
				return 0;
			}
		}
		departments.add(department);
		return 1;
	}

	public int updateDepartment(Department department) {
		for(Department d: departments) {
			if(d.getId() == department.getId()) {
				d = department;
				return 1;
			}
		}
		return 0;
	}

	public int deleteDepartmentById(int id) {
		for(Department d: departments) {
			if(d.getId() == id) {
				departments.remove(d);
				return 1;
			}
		}		return 0;
	}


}
