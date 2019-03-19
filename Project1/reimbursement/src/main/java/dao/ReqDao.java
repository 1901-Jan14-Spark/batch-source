package dao;

import java.util.List;

import model.ReqObj;

public interface ReqDao {
	public List<ReqObj> getAllReq();
	public List<ReqObj> getReqById(int id);
	public boolean addReq(int empId, ReqObj request);
	public boolean updateReq(int mId, ReqObj reqAns);
}
