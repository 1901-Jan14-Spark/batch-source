package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.model.Location;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	DepartmentDao dd = new DepartmentDaoImpl();
	LocationDao ld = new LocationDaoImpl();
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection con = ConnectionUtil.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while (rs.next()) {
				Employee e = new Employee(); 
				
				int employeeId = rs.getInt("EMP_ID");
				e.setId(employeeId);
				
				String name = rs.getString("EMP_NAME");
				e.setName(name);
				
				Date birthday = rs.getDate("BIRTHDAY");
				e.setBirthday(birthday);
				
				double salary = rs.getDouble("MONTHLY_SALARY");
				e.setMonthlySalary(salary);
				
				String position = rs.getString("POSITION");
				e.setPosition(position);
				
				int managerId = rs.getInt("MANAGER_ID");
				e.setManagerId(managerId);
				
				Date hireDate = rs.getDate("HIRE_DATE");
				e.setHireDate(hireDate);
				
				int deptId = rs.getInt("DEPT_ID");
//				e.setDepartmentId(deptId);
				e.setDepartment(new Department(deptId));
				
				
				int locId = rs.getInt("LOCATION_ID");
//				e.setLocationId(locId);
				e.setLocation(new Location(locId));
				
				employees.add(e);
				
			}
			
			// get all of the departments in my db
			List<Department> departments = dd.getDepartments();
			List<Location> locations = ld.getLocations();
			
			// iterate through my employee list
			for(Employee e : employees) {
				// for each employee access their department's id
				int deptId = e.getDepartment().getId();
				if(deptId!=0) { // if they have an id in the db (not 0 not null)
					for(Department d: departments) {
						if(deptId == d.getId()) {
							e.setDepartment(d);
						}
					}
				}
				int locId = e.getLocation().getId();
				if(locId!=0) {
					for(Location l: locations) {
						if(locId == l.getId()) {
							e.setLocation(l);
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
