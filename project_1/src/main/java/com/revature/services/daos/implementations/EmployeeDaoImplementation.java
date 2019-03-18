package com.revature.services.daos.implementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.services.daos.interfaces.EmployeeDao;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImplementation implements EmployeeDao {

	static Logger log = Logger.getRootLogger();

	// Password is not returned for security reasons
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT E_ID, E_EMAIL, E_FIRSTNAME, E_LASTNAME, E_ISMANAGER FROM EMPLOYEES";

		try (Connection con = ConnectionUtil.getConnectionFromFile();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {

			while (rs.next()) {

				int e_id = rs.getInt("E_ID");
				String email = rs.getString("E_EMAIL");
				String firstname = rs.getString("E_FirstName");
				String lastname = rs.getString("E_LastName");
				int mLevel = rs.getInt("E_ISMANAGER");

				employees.add(new Employee(e_id, email, firstname, lastname, mLevel));
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

	@Override
	public Employee getEmployeeByEmail(String email) {
		String sql = "SELECT E_ID, E_EMAIL, E_PaSSWORD, E_FIRSTNAME, E_LASTNAME, E_ISMANAGER FROM EMPLOYEES WHERE E_EMAIL = ?";
		Employee TempEmp = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int e_id = rs.getInt("E_ID");
				String e_email = rs.getString("E_EMAIL");
				String password = rs.getString("E_PASSWORD");
				String firstname = rs.getString("E_FirstName");
				String lastname = rs.getString("E_LastName");
				int isManager = rs.getInt("E_ISMANAGER");

				TempEmp = new Employee(e_id, e_email, password, firstname, lastname, isManager);
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getEmployeeByEmail(): id: " + email);
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getEmployeeByEmail(): id: " + email);
			e2.printStackTrace();
		}
		return TempEmp;
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT E_ID, E_EMAIL, E_PaSSWORD, E_FIRSTNAME, E_LASTNAME, E_ISMANAGER FROM EMPLOYEES WHERE E_ID = ?";
		Employee TempEmp = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int e_id = rs.getInt("E_ID");
				String email = rs.getString("E_EMAIL");
				String password = rs.getString("E_PASSWORD");
				String firstname = rs.getString("E_FirstName");
				String lastname = rs.getString("E_LastName");
				int isManager = rs.getInt("E_ISMANAGER");

				TempEmp = new Employee(e_id, email, password, firstname, lastname, isManager);
			}
		} catch (SQLException e1) {
			log.error("SQLException - unable to getEmployeeById(int id): id: " + id);
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to getEmployeeById(int id): id: " + id);
			e2.printStackTrace();
		}
		return TempEmp;
	}

	@Override
	public int createEmployee(Employee e) throws SQLException, IOException {
		String sql = "Insert into EMPLOYEES (E_EMAIL, E_PASSWORD, E_FIRSTNAME, E_LASTNAME, E_ISMANAGER) VALUES (?,?,?,?,?)";
		int empCreated = 0;

		Connection con = ConnectionUtil.getConnectionFromFile();
		PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getFirstname());
			ps.setString(4, e.getLastname());
			ps.setInt(5, e.getManagerLevel());
			
			empCreated = ps.executeUpdate();
			con.close();
			ps.close();
		return empCreated;
	}

	@Override
	public int updateEmployee(Employee e) {
		
		String sql = "UPDATE EMPLOYEES "
				+ "SET "
				+ "E_EMAIL = ?, "
				+ "E_PASSWORD = ?, "
				+ "E_FIRSTNAME = ?, "
				+ "E_LASTNAME = ?, "
				+ "E_ISMANAGER = ? "
				+ "WHERE E_ID = ?";
		int updated = 0;
		try (Connection con = ConnectionUtil.getConnectionFromFile();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getFirstname());
			ps.setString(4, e.getLastname());
			ps.setInt(5, e.getManagerLevel());
			ps.setInt(6, e.getId());
			
			updated = ps.executeUpdate();
		} catch (SQLException e1) {
			log.error("SQLException - unable to updateEmployee(): " + e);
			e1.printStackTrace();
		} catch (IOException e2) {
			log.error("IOException - unable to updateEmployee(): " + e);
			e2.printStackTrace();
		}
		return updated;
	}

}
