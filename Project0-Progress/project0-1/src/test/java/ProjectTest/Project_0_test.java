package ProjectTest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.rev.main.Driver;
import com.rev.util.Customer;
import com.rev.util.CustomerDaoImpl;

public class Project_0_test {

	private static final Driver testCase = new Driver();
	private static final CustomerDaoImpl tester = new CustomerDaoImpl();
	
	
	//testing the addCutomerMethod from Dao implimintation
	
	@Test 
	public void testAddCustomer() {
		Customer test = new Customer();
		assertEquals(1,tester.addCustomer(test));
	}
	
	@Test
	public void testGetCustomerById(){
		Customer test = new Customer();
		assertEquals(test,tester.getCustomerById(5));
	}
	@Test
	public void testChangeBalance() {
		assertEquals(1,tester.changeCustomerBalance(1, 0));
	}
	@Test
	public void testNotChangeBal() {
		assertEquals(1,tester.changeCustomerBalance(1,-1));
	}
	@Test
	public void testWithdraw() {
		//String test = "20";
		//InputStream in = new ByteArrayInputStream(test.getBytes());
		//System.setIn(in);
		assertEquals(120,tester.withdraw(1, 20));
		//System.setIn(System.in);
	}
	@Test
	public void TestgetUserById() {
		assertEquals(0,tester.getIdByUser("agilay"));
	}
	
	
	
	
}
