package com.revature.service;

import java.util.List;

import com.revature.DAO.EmployeeDAO;
import com.revature.DAO.EmployeeDAO_Impl;
import com.revature.DAO.RequestDAO;
import com.revature.DAO.RequestDAO_Impl;
import com.revature.models.Employee;
import com.revature.models.Request;

public class EmployeeService {
	EmployeeDAO empDao = new EmployeeDAO_Impl();
	RequestDAO reqDao = new RequestDAO_Impl();
	public List<Employee> getAll() {
		return empDao.getEmployees();
	}
	public List<Request> getActive() {
		return reqDao.getActiveRequests();
	}
	public List<Request> getResolve() {
		return reqDao.getResolvedRequests();
	}
	public  Employee getEmployeeByUsername(String username) {
		
		return empDao.getEmpByUsername(username);
	}
	public int createRequest(Request r) {
		return reqDao.createRequest(r);
	}
	public void changeInfo(int id, String name, String user, String pass) {
		 empDao.changeInfo(id, name, user, pass);
	}
	public void approveRequest(int ReimId, int EmpId) {
		 reqDao.approveRequest(ReimId, EmpId);
	}
	public void denyRequest(int ReimId, int EmpId) {
		 reqDao.denyRequest(ReimId, EmpId);
	}
	public List<Request> getActiveRequest(String name) {
		return reqDao.getActiveRequest(name);
	}
	public List<Request> getResolvedRequest(String name) {
		return reqDao.getResolvedRequest(name);
	}
}
