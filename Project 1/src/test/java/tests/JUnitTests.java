package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import dao.EmployeeDaoImpl;
import models.Employee;
import services.EmployeeService;
import services.LoginService;
import util.DBConnection;

class JUnitTests {

	Employee testEmp = new Employee("mockUser@gmail.com", "correct");
	
	@Before
	public int createMockData() {		
		String sql = "INSERT INTO EMPLOYEE (EMAIL, PASSWORD) VALUES (?, ?)";
		int mockNumCreated = 0;
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, testEmp.getEmail());
			ps.setString(2, testEmp.getPassword());
			mockNumCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mockNumCreated;
	}
	
	@After
	public void removeMockAcc() {
		String emailToDelete;
		emailToDelete = testEmp.getEmail();
		String sql = "DELETE FROM EMPLOYEE WHERE EMAIL = ?";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, emailToDelete);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//testing as if my database would be empty
	@Test
	void testGetEmployeesNoRealUser() {
		LoginService loginServiceMock = mock(LoginService.class);
		Employee testEmp = new Employee();
		
		when(loginServiceMock.confirmLogin("dummy@gmail.com", "dummyP")).thenReturn(testEmp);
		
		EmployeeDaoImpl empDao = new EmployeeDaoImpl(loginServiceMock);
		Employee emp = empDao.getEmployeeByUsername("dummy@gmail.com");
		assertEquals(null, emp);
	}

	@Test
	void testEmptyLists() {
		EmployeeDaoImpl empDaoMock = mock(EmployeeDaoImpl.class);
		EmployeeService empServiceMock = mock(EmployeeService.class);
		
		List<Employee> testList = new ArrayList<>();
		Employee e = new Employee();
		
		when(empServiceMock.getEmployeesList()).thenReturn(testList);
		List<Employee> newList = empDaoMock.getOnlyEmployees();
		assertEquals(newList, testList);
	}

	
}