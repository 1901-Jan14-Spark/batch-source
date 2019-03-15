package dao;

import java.util.List;

import model.EmpObj;

public interface EmpDao {
	public List<EmpObj> getAllEmp();
	public List<EmpObj> getAllMan();
	public EmpObj getIdAndPass(int userId);
}
