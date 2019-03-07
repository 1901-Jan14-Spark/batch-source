package com.revature.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.banking.Logging;

public class junitTests {
	
	@Test
	public void testOnlyCharactersInputforpassVerification() {
		assertFalse(Logging.passVerification("ascdfgh"));
	}
	
	@Test
	public void testOnlyNumbersInputForpassVerification() {
		assertFalse(Logging.passVerification("019284"));
	}
	

	@Test
	public void testEmptyStringInputForpassVerification() {
		assertFalse(Logging.passVerification(""));
	}
	
	
	@Test
	public void testGoodPassValidatePassword() {
		assertTrue(Logging.passVerification("KandJ1130!"));
	}

	

	



}
