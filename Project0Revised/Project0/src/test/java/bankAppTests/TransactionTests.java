package bankAppTests;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runners.MethodSorters;

import bankApplication.Transaction;
import bankApplication.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionTests {
	@Test
	public void testExpectedNumberInputForValidateDouble() {
		String input = "43.88";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		//set custom "standard" input stream
		System.setIn(in);
		assertEquals(43.88, Transaction.validateDouble(),0.01);
		//reset "standard" input stream to default
		System.setIn(System.in);
	}
	
	@Test
	public void testWholeNumberInputForValidateDouble() {
		String input = "17";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		//set custom "standard" input stream
		System.setIn(in);
		assertEquals(17, Transaction.validateDouble(),0.01);
		//reset "standard" input stream to default
		System.setIn(System.in);
	}
	
	@Test
	public void testNumbersBeyondHundrethPlaceInputForValidateDouble() {
		String input = "23.5487";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		//set custom "standard" input stream
		System.setIn(in);
		assertEquals(23.55, Transaction.validateDouble(),0.01);
		//reset "standard" input stream to default
		System.setIn(System.in);
	}
	
	//method should not return any value when user enters a negative number so exception should be expected
	@Test(expected = NoSuchElementException.class)
	public void testNegativeNumberInputForValidateDouble() {
		String input = "-2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		//set custom "standard" input stream
		System.setIn(in);
		assertEquals(2.0, Transaction.validateDouble(),0.01);
		//reset "standard" input stream to default
		System.setIn(System.in);
	}
	
	//method should not return any value when user enters a string (or char), so exception should be expected
	@Test(expected = NoSuchElementException.class)
	public void testStringInputForValidateDouble() {
		String input = "ascdfgh";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		//set custom "standard" input stream
		System.setIn(in);
		assertEquals(2.0, Transaction.validateDouble(),0.01);
		//reset "standard" input stream to default
		System.setIn(System.in);
	}
	
	@Test
	public void testOnlyCharactersInputforValidateString() {
		assertTrue(User.validateString("ascdfgh"));
	}
	
	@Test
	public void testOnlyNumbersInputForValidateString() {
		assertFalse(User.validateString("019284"));
	}
	
	@Test
	public void testStringAndNumberInputForValidateString() {
		assertTrue(User.validateString("username53"));
	}
	
	@Test
	public void testEmptyStringInputForValidateString() {
		assertFalse(User.validateString(""));
	}
	
	@Test
	public void testOnlySpaceInputForValidateString() {
		assertFalse(User.validateString(" "));
	}
	
	@Test
	public void testValidPotentialPasswordForValidatePassword() {
		assertTrue(User.validatePassword("p4ssw0rd"));
	}
	
	@Test
	public void testOnlyCharactersInputForValidatePassword() {
		assertFalse(User.validatePassword("aksldkng"));
	}
	
	@Test
	public void testOnlyNumbersInputForValidatePassword() {
		assertFalse(User.validatePassword("93924854"));
	}
	
	@Test
	public void testTooShortInputForValidatePassword() {
		assertFalse(User.validatePassword("A1"));
	}
	
	@Test
	public void testEmptyStringInputForValidatePassword() {
		assertFalse(User.validatePassword(""));
	}
	
	@Test
	public void testOnlySpaceInputForValidatePassword() {
		assertFalse(User.validatePassword(" "));
	}
}
