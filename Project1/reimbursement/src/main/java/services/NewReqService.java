package services;

import dao.ReqDao;
import dao.ReqDaoImpl;
import model.ReqObj;

public class NewReqService {
	//method updates Requests table in DB
	public boolean createReq(int empId, double amount, String desc) {
		boolean success = false;
		ReqDao rd = new ReqDaoImpl();
		ReqObj newRequest = new ReqObj();
		
		//populate request object
		newRequest.setDesc(desc);
		newRequest.setAmount(amount);
		
		//update table with new request object
		success = rd.addReq(empId, newRequest);
		
		return success;
	}
}
