package com.revature.dao.im;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.EmployeeDao;
import com.revature.model.Department;
import com.revature.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	DepartmentDao deptDao = new DepartmentDaoImpl();
	
	List<Employee> employees = new ArrayList<>();
	
	public EmployeeDaoImpl() {
		super();
		employees.add(new Employee(1, "Lisa Jones", Date.valueOf("1988-02-08"), 1200.87, Date.valueOf("2017-10-03"), "Sales Director", 0,3));
		employees.add(new Employee(2, "Ollie Eliasen", Date.valueOf("1973-02-06"), 2732.99, Date.valueOf("2016-07-23"), "Sales Representative", 1, 3));
		employees.add(new Employee(3, "Betsy Bartali", Date.valueOf("1994-03-12"), 1326.82, Date.valueOf("2017-01-25"), "Sales Representative", 1, 3));
		employees.add(new Employee(4, "Brandon Carrabott", Date.valueOf("1993-03-11"), 2228.87, Date.valueOf("2015-11-11"), "HR Director", 0, 1));
		employees.add(new Employee(5, "Winona Balassa", Date.valueOf("1978-09-16"), 2624.36, Date.valueOf("2018-08-23"), "HR Representative", 4, 1));
		employees.add(new Employee(6, "Gwyneth Pigne", Date.valueOf("1989-10-11"), 1359.71, Date.valueOf("2015-06-18"), "HR Representative", 4, 1));
		employees.add(new Employee(7, "Perry Pitkins", Date.valueOf("1987-02-09"), 2793.79, Date.valueOf("2015-03-05"), "IT Director", 0, 3));
		employees.add(new Employee(8, "Rasla Pool", Date.valueOf("1983-06-04"), 1878.01, Date.valueOf("2018-06-25"), "IT Professional", 7, 3));
		employees.add(new Employee(9, "Jodie Hounsom", Date.valueOf("1980-03-07"), 1404.45, Date.valueOf("2015-12-19"), "IT Assisstant", 8, 3));
		employees.add(new Employee(10, "Layney Goretti", Date.valueOf("1986-03-01"), 1651.55, Date.valueOf("2016-12-27"), "IT Professional", 7, 3));

	}

	public List<Employee> getEmployees() {
		for(Employee e: employees) {
			for(Department d: deptDao.getDepartments()) {
				if(e.getDepartment()!=null && e.getDepartment().getId() == d.getId()) {
					e.setDepartment(d);
				}
			}
		}
		return employees;
	}

	public Employee getEmployeeById(int id) {
		Employee employee = null;
		for(Employee e: employees) {
			if(e.getId() == id) {
				employee = e;
			}
		}
		if(employee!=null && employee.getDepartment()!=null) {
			employee.setDepartment(deptDao.getDepartmentById(employee.getDepartment().getId()));
		}
		return employee;
	}

	public int createEmployee(Employee employee) {
		int maxId = 0;
		for(Employee e : employees) {
			if(e.getId()==employee.getId()) {
				return 0;
			}
			if(e.getId()>maxId) {
				maxId = e.getId();
			}
		}
		employee.setId(maxId+1);
		employees.add(employee);
		return 1;
	}

	public int updateEmployee(Employee employee) {
		for(Employee e: employees) {
			if(e.getId()== employee.getId()) {
				e = employee;
				return 1;
			}
		}
		return 0;
	}

	public int deleteEmployeeById(int id) {
		for(Employee e: employees) {
			if(e.getId()== id) {
				employees.remove(e);
				return 1;
			}
		}
		return 0;
	}

}
