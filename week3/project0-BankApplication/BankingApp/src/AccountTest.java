

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Bank.Account;
import com.Bank.User;

class AccountTest {

	@Test 
	public void testdepositMoney() {
		
		User user = new User();
		
		//insert value in to method
	  user.getAccount().depositChecking(user, 30);
	  
         //verify if the value is as expected
		assertEquals(30, user.getAccount().getChecking());
		
		
	}
	
	@Test
	public void testwithdrawMoney() {
		
		User user = new User();
		
	
		
		 user.getAccount().setChecking(100);
		//test withdrawing works
		  assertTrue(user.getAccount().withdrawMoneyChecking(40, user));
		
		
		
	  //test overdrawing account is prevented 
	  assertFalse(user.getAccount().withdrawMoneyChecking(400, user));
	  

	}
	
	
	
	
	
	
	
	

}
