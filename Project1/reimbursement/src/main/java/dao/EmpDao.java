package dao;

import java.util.List;

import model.EmpObj;

public interface EmpDao {
	public List<EmpObj> getAllEmp();
	public List<EmpObj> getOnlyEmp();
	public List<EmpObj> getOnlyMan();
	public EmpObj getEmpById(int userId);
	public EmpObj getIdAndPass(int userId);
	public boolean updateEmp(int empId, EmpObj employee);
}
