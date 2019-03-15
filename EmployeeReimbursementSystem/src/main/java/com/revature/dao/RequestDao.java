package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Request;

public interface RequestDao {
	List<Request> getRequests();
	Request getRequestById(int id);
	Request getRequestById(int id, Connection con);
	List<Request> getPendingRequest();
	List<Request> getResolvedRequests();
	List<Request> getRequestsByEmployeeId(int employeeId);
	List<Request> getPendingRequestsByEmployeeId(int employeeId);
	List<Request> getResolvedRequestsByEmployeeId(int employeeId);
	List<Request> getRequestsByEmployeeIdForManagerHome(int employeeId);
	List<Request> getPendingRequestsByEmployeeIdForManagerHome(int employeeId);
	List<Request> getResolvedRequestsByEmployeeIdForManagerHome(int employeeId);
	void addRequest(Request r);
	void updateRequest(Request r);
}
