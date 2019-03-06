import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Bank.BankView;

class BankViewTest {

	@Test
	void validateUserString() {
		
		BankView BV  = new BankView();
		 
		
		assertTrue(BV.validateUsernameString("weiuweeehewo"));
		assertFalse(BV.validateUsernameString("wei2322ehe*(*(wo"));
		
	}

	
	@Test
	void validateNameString() {
		
		BankView BV  = new BankView();
		 
		
		assertTrue(BV.validateNameString("weiuweeehewo"));
		assertFalse(BV.validateNameString("wei2322ehwo"));
		
	}
	
	
	
	@Test
	void validateAndSetPassword() {
		
		BankView BV  = new BankView();
		 
		BV.validateAndSetPassword("weiuweeehewo");
	    assertEquals("weiuweeehewo", BV.getPassword());
		
		BV.validateAndSetPassword("weiuw  eeehewo");
		assertEquals(null, BV.getPassword());

	
	}
	
	
	
}
