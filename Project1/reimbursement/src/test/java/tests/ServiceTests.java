package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dao.ReqDaoImpl;
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
	
	@Test
	public void test0ForConvStat() {
		assertEquals("Pending", ReqDaoImpl.convStat(0));
	}
	
	@Test
	public void test1ForConvStat() {
		assertEquals("Approved", ReqDaoImpl.convStat(1));
	}
	
	@Test
	public void test2ForConvStat() {
		assertEquals("Rejected", ReqDaoImpl.convStat(2));
	}
}
