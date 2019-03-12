package com.revature;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AnnotationTest {
	
	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("called runBeforeClass method");
	}
	
	@Before
	public void runBefore() {
		System.out.println("called runBefore method");
	}
	
	@After 
	public void runAfter() {
		System.out.println("called runAfter method");
	}
	
	@AfterClass
	public static void runAfterClass() {
		System.out.println("called runAfterClass method");
	}
	
	@Test
	public void testOne() {
		System.out.println("Called test one");
		assertEquals(5,5);
	}
	
	@Test
	@Ignore
	public void testTwo() {
		System.out.println("Called test two");
		assertArrayEquals(new int[] {1,2}, new int[] {2,1});
	}
	
	@Test
	@Ignore
	public void testThree() {
		System.out.println("Called test three");
		fail("test three failed!!");
	}

}
