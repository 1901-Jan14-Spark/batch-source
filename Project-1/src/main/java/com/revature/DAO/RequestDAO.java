package com.revature.DAO;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Request;

public interface RequestDAO {
public int createRequest(Request r);
public List<Request> getActiveRequests();
public List<Request> getResolvedRequests();
public void approveRequest(int ReimId, int EmpId);
public void denyRequest(int ReimId, int EmpId);
public List<Request> getActiveRequest(String name);
public List<Request> getResolvedRequest(String name);
}
