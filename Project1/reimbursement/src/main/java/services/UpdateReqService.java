package services;

import dao.EmpDao;
import dao.EmpDaoImpl;
import dao.ReqDao;
import dao.ReqDaoImpl;
import model.ReqObj;

public class UpdateReqService {
	ReqDao rd = new ReqDaoImpl();
	EmpDao ed = new EmpDaoImpl();
	
	public boolean createReqAns(int rId, int mId, String status) {
		ReqObj reqAnswer = new ReqObj();
		boolean success = false;
		
		//create request answer
		reqAnswer.setrId(rId);
		reqAnswer.setStatus(status);
		
		success = rd.updateReq(mId, reqAnswer);
		
		return success;
	}
}
