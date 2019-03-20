package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.service.LoginService;




public class AppTests {
	LoginService ls = new LoginService();
	
	@Test
	
//	public void testForInvlaidInputValidation() {
//		assertEquals("Employee has no EMail: No Email of Invalid Email", ls.validation(null , null ));
//	}
	
	public void testForNullInputValidation() {
		assertEquals("Employee Does not Exist: No Email of Invalid Email", ls.validation("dfsdfasf@sfasfasf" ,"asfasfasfasf" ));
	}
}
