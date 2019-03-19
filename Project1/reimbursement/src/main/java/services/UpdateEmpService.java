package services;

import dao.EmpDao;
import dao.EmpDaoImpl;
import model.EmpObj;

public class UpdateEmpService {
	EmpDao ed = new EmpDaoImpl();
	
	public boolean createEmp(int empId, String name, String email, String password) {
		boolean success = false;
		EmpObj modEmp = new EmpObj();
		
		modEmp.seteName(name);
		modEmp.setEmail(email);
		modEmp.setePass(password);
		
		success = ed.updateEmp(empId, modEmp);
		
		return success;
	}
}
