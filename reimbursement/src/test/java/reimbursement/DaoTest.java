package reimbursement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDaoImpl;

public class DaoTest {

    private static final EmployeeDaoImpl testing = new EmployeeDaoImpl();
    private static final ManagerDaoImpl testing2 = new ManagerDaoImpl();
    private static final RequestDaoImpl testing3 = new RequestDaoImpl();

	@Test
	public void getEmployeeById() {
		assertEquals("jessica",testing.getEmployeeById(1).getFirstname());
	}
	
	@Test 
	public void getEmployeeByUsername() {
		assertEquals("jessica",testing.getEmployeeByUsername("jess@msn.com").getFirstname());
	}
	
	@Test
	public void getManagerById() {
		assertEquals("younes",testing2.getManagerById(1).getFirstname());
	}
	
	@Test 
	public void getManagerByUsername() {
		assertEquals("younes",testing2.getManagerByUsername("user@msn.com").getFirstname());
	}
	
	@Test 
	public void getManagerByUsername2() {
		assertEquals("wardaoui",testing2.getManagerByUsername("user@msn.com").getLastname());
	}
	
	@Test
	public void getRequestById() {
		assertEquals("Pending",testing3.getRequestById(1).getStatus());
	}
	
}


