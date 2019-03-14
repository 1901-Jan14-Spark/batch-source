package utilities;

import java.util.List;

import daos.Employee;
import daos.EmployeeDao;
import daos.EmployeeDaoImp;

public class EmployeeService implements CrudService<Employee>{

	EmployeeDao empDao = new EmployeeDaoImp();
	
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return empDao.getEmployees();
	}

	@Override
	public Employee getEmpByUser(String username) {
		
		return empDao.getEmpByUser(username);
	}
	
	 

}
