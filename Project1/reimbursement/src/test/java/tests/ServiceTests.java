package tests;

import static org.junit.Assert.*;

import org.junit.*;

import services.LoginService;

public class ServiceTests {
	LoginService ls = new LoginService();
	
	@Test
	public void testExpectedInputForValidIdInput() {
		assertEquals(20001, ls.validIdInput("20001"));
	}
	
	@Test
	public void testEmptyInputForValidIdInput() {
		assertEquals(0, ls.validIdInput(""));
	}
	
	@Test
	public void testNaNInputForValidIdInput() {
		assertEquals(0, ls.validIdInput("not a number"));
	}
}
