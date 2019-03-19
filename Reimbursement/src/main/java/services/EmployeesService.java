package services;

import java.util.List;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import models.Employees;

public class EmployeesService implements EmployeesDao {

	EmployeesDao empImpl = new EmployeesDaoImpl();

	@Override
	public List<Employees> getAll() {
		return empImpl.getAll();
	}

	@Override
	public List<Employees> getEmployees() {
		return empImpl.getEmployees();
	}

	@Override
	public List<Employees> getManagers() {
		return empImpl.getManagers();
	}

	@Override
	public Employees getEmployeesById(int id) {
		return empImpl.getEmployeesById(id);
	}

	@Override
	public int createEmployee(Employees emp) {
		return empImpl.createEmployee(emp);
	}

	@Override
	public int updateEmployee(Employees emp) {
		return empImpl.updateEmployee(emp);
	}

	@Override
	public int deleteEmployeesById(int id) {
		return empImpl.deleteEmployeesById(id);
	}

	@Override
	public Employees getEmployeesByIsMana(int stat) {
		return empImpl.getEmployeesByIsMana(stat);
	}

	@Override
	public Employees getEmployeeByUser(String user, String pass) {
		return empImpl.getEmployeeByUser(user, pass);
	}

}
