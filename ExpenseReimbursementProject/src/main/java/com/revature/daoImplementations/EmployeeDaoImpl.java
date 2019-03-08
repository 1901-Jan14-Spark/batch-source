package com.revature.daoImplementations;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	static Logger log = Logger.getRootLogger();

	// Does not return passwords for security reasons
	@Override
	public List<Employee> getEmployeesAssociatedTo(Employee e) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT E_ID, E_EMAIL, E_FIRSTNAME, E_LASTNAME, E_REPORTSTO FROM EMPLOYEES WHERE E_REPORTSTO = ?";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, e.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int e_id = rs.getInt("E_ID");
				String email = rs.getString("E_EMAIL");
				String firstname = rs.getString("E_FirstName");
				String lastname = rs.getString("E_LastName");
				int m_id = rs.getInt("E_REPORTSTO");
				
				employees.add(new Employee(e_id, email, firstname, lastname, m_id));
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getEmployeesAssociatedTo(int id): id: " + e.getId());
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getEmployeesAssociatedTo(int id): id: " + e.getId());
			e2.printStackTrace();
		}
		return employees;
	}

	// Does not return passwords for security reasons
	@Override
	public Employee getEmployee(Employee e) {
		String sql = "SELECT E_ID, E_EMAIL, E_FIRSTNAME, E_LASTNAME, E_REPORTSTO FROM EMPLOYEES WHERE E_ID = ?";
		Employee TempEmp = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, e.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int e_id = rs.getInt("E_ID");
				String email = rs.getString("E_EMAIL");
				String firstname = rs.getString("E_FirstName");
				String lastname = rs.getString("E_LastName");
				int reportsTo = rs.getInt("E_REPORTSTO");

				TempEmp = new Employee(e_id, email, firstname, lastname, reportsTo);
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getEmployeeById(int id): id: " + e.getId());
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getEmployeeById(int id): id: " + e.getId());
			e2.printStackTrace();
		}
		return TempEmp;
	}

	// Returns employee password for identification purposes
	@Override
	public Employee getEmployeeByEmail(String email) {
		String sql = "SELECT E_ID, E_EMAIL, E_PASSWORD, E_FIRSTNAME, E_LASTNAME FROM EMPLOYEES WHERE E_EMAIL = ?";
		Employee TempEmp = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int e_id = rs.getInt("E_ID");
				String password = rs.getString("E_password");
				String firstname = rs.getString("E_FirstName");
				String lastname = rs.getString("E_LastName");

				TempEmp = new Employee(e_id, email, password, firstname, lastname);
			}
		} catch (SQLException e) {
			log.error("SQLException - unable to getEmployeeByEmail(String email): email: " + email);
			e.printStackTrace();
		} catch (IOException e1) {
			log.error("IOException - unable to getEmployeeByEmail(String Email): email: " + email);
			e1.printStackTrace();
		}
		return TempEmp;
	}
	
	//Pass in a randomized password when Creating
	@Override
	public int createEmployee(String email, String password, int managerId) {
		String sql = "Insert into EMPloyees (E_EMAIL, E_PASSWORD, E_REPORTSTO) VALUES (?,?,?)";
		int empCreated = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setInt(3, managerId);
			empCreated = ps.executeUpdate();
		} catch (SQLException e) {
			log.error("SQLException - unable to createEmployee(): email: "+ email+" password: " + password + " managerId: " + managerId);
			e.printStackTrace();
		} catch (IOException e1) {
			log.error("IOException - unable to createEmployee(): email: "+ email+" password: " + password + " managerId: " + managerId);
			e1.printStackTrace();
		}
		return empCreated;
	}

	@Override
	public boolean updateEmployeeInfo(Employee e) {
		String sql = "{call updateEmployee(eid => ?, email => ?, epassword => ?, efirstname =>?, elastname =>?, ereportsto => ?)}";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall(sql)) {
			cs.setInt(1, e.getId());
			cs.setString(2, e.getEmail());
			cs.setString(3, e.getPassword());
			cs.setString(4, e.getFirstname());
			cs.setString(5, e.getLastname());
			if(e.getManagerId() == 0) {
			cs.setNull(6, 0);
			}else {
				cs.setInt(6, e.getManagerId());
			}
			cs.execute();
		} catch (SQLException e1) {
			log.error("SQLException - unable to updateEmployee(): employee: "+ e.toString());
			return false;
		} catch (IOException e2) {
			log.error("IOException - unable to updateEmployee(): employee: "+ e.toString());
			return false;
		}
		return true;
	}

	@Override
	public boolean changeLoggedInField(Employee e) {
		String sql = "{call CHANGEEMPLOYEELOGIN(?)}";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall(sql)) {
			cs.setInt(1, e.getId());
			cs.execute();
		} catch (SQLException e1) {
			log.error("SQLException - unable to changeLoggedInField(): employee: "+ e.toString());
			return false;
		} catch (IOException e2) {
			log.error("IOException - unable to changeLoggedInField(): employee: "+ e.toString());
			return false;
		}
		return true;
	}


	@Override
	public void upgradeToManager(Employee e) {
		String sql = "{call PROMOTEEMPLOYEE(?)}";
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				CallableStatement cs = con.prepareCall(sql)) {
			cs.setInt(1, e.getId());
			cs.execute();
		} catch (SQLException e1) {
			log.error("SQLException - unable to upgradeToManager(): employee: "+ e.toString());
		} catch (IOException e2) {
			log.error("IOException - unable to upgradeToManager(): employee: "+ e.toString());
		}
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT E_ID, E_EMAIL, E_FIRSTNAME, E_LASTNAME, E_REPORTSTO FROM EMPLOYEES";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement(); ResultSet rs = s.executeQuery(sql);) {

			while (rs.next()) {

				int e_id = rs.getInt("E_ID");
				String email = rs.getString("E_EMAIL");
				String firstname = rs.getString("E_FirstName");
				String lastname = rs.getString("E_LastName");
				int m_id = rs.getInt("E_REPORTSTO");
				
				employees.add(new Employee(e_id, email, firstname, lastname, m_id));
			}
		} catch (SQLException e) {
			log.error("SQLException - unable to getEmployees()");
			e.printStackTrace();
		} catch (IOException e1) {
			log.error("IOException - unable to getEmployees()");
			e1.printStackTrace();
		}
		return employees;
	}

}
