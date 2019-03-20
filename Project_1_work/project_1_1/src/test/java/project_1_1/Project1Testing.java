package project_1_1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import daos.EmployeeDaoImp;
import daos.Request;

public class Project1Testing {

	private static final EmployeeDaoImp tester = new EmployeeDaoImp();
	
	@Test
	public void testMangerId() {

		assertEquals(20,tester.getManager("aspurr1e"));
	}
	
	@Test
	public void testManagerName() {
		assertEquals("Andreas",tester.getManagerName("aspurr1e"));
	}
	@Test 
	public void testGetEmpByUsername() {
		assertEquals("Aland",tester.getEmpByUser("aspurr1e").getFirstName());
	}
	@Test 
	public void testGetIdByUsername() {
		assertEquals(20,tester.getEmpByUser("aspurr1e").getEmployeeId());
		
	}
	
	
	
}
