package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void testInvalidPassword() {
		
		assertFalse("12312SAdas", "12312SAdas".matches("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9])(?=\\S*?[!@#$%^&*]).{8,})\\S$"));
	}

	@Test
	public void testInvalidPassword2() {
		assertFalse("R0c!s", "R0c!s".matches("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9])(?=\\S*?[!@#$%^&*]).{8,})\\S$"));
	}
	
	@Test
	public void testValidPassword() {
		assertTrue("R0tos#124", "R0tos#124".matches("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9])(?=\\S*?[!@#$%^&*]).{8,})\\S$"));
	}
	
	@Test
	public void testInvalidPassword3() {
		assertFalse("oasdaosdado@A", "oasdaosdado@A".matches("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9])(?=\\S*?[!@#$%^&*]).{8,})\\S$"));
	}
}
