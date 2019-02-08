package com.revature.spark;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.spark.beans.Expense;
import com.revature.spark.beans.User;
import com.revature.spark.todo.AssociateImplementation;

public class BudgetingApplicationTests {
	
	static AssociateImplementation service = new AssociateImplementation();
	static double precision = 0.01; 
	static List<Expense> expenses;
	static List<Expense> moreExpenses;
	static List<Expense> oddexpenses;
	static User dan;
	static User randolph;
	static User howard;
	
	@BeforeClass
	public static void before() {
		dan = new User(1, "Dan", "Pickles");
		randolph = new User(2, "Randolph", "Scott");
		howard = new User(3, "Howard", "Johnson");
	
		// even calls
		expenses = new LinkedList<>();
		expenses.add(new Expense(1, "a", "A", 1.50, dan));
		expenses.add(new Expense(2, "b", "B", 2.50, dan));
		expenses.add(new Expense(3, "c", "C", 3.10, dan));
		expenses.add(new Expense(4, "d", "D", 4.50, dan));
		expenses.add(new Expense(5, "e", "A", 4.10, randolph));
		expenses.add(new Expense(6, "f", "B", 2.15, randolph));
		expenses.add(new Expense(7, "g", "C", 3.25, randolph));
		expenses.add(new Expense(8, "h", "D", 10.50, howard));
		expenses.add(new Expense(9, "i", "A", 11.20, howard));
		expenses.add(new Expense(10, "j", "B", 15.50, howard));
		
		// odd calls
		oddexpenses = new LinkedList<>();
		oddexpenses.add(new Expense(1, "a", "A", 1.50, dan));
		oddexpenses.add(new Expense(2, "b", "B", 2.50, dan));
		oddexpenses.add(new Expense(3, "c", "C", 3.10, dan));
		oddexpenses.add(new Expense(6, "f", "B", 2.15, randolph));
		oddexpenses.add(new Expense(7, "g", "C", 3.25, randolph));
		oddexpenses.add(new Expense(8, "h", "D", 10.50, howard));
		oddexpenses.add(new Expense(10, "j", "B", 15.50, howard));
		
		moreExpenses = new LinkedList<>();
		moreExpenses.add(new Expense(1, "a", "A", 7.50, dan));
		moreExpenses.add(new Expense(2, "b", "A", 8.50, dan));
		moreExpenses.add(new Expense(3, "c", "C", 3.10, dan));
		moreExpenses.add(new Expense(4, "d", "D", 9.50, dan));
		moreExpenses.add(new Expense(5, "e", "A", 4.10, randolph));
		moreExpenses.add(new Expense(6, "f", "B", 2.15, randolph));
		moreExpenses.add(new Expense(7, "g", "B", 3.25, randolph));
		moreExpenses.add(new Expense(8, "h", "C", 2.50, howard));
		moreExpenses.add(new Expense(9, "i", "C", 1.20, howard));
		moreExpenses.add(new Expense(10, "j", "B", 15.50, howard));
	} 
	
	@Test
	public void sumTest() {
		double sum = 58.3;
		double testSum = service.sum(expenses);
		assertEquals(sum, testSum, precision);
	}

	@Test
	public void minTest() {
		double min = 1.5;
		double testMin = service.min(expenses);
		assertEquals(min, testMin, precision);
	}

	@Test
	public void maxTest() {
		double max = 15.5;
		double testMax = service.max(expenses);
		assertEquals(max, testMax, precision);
	}

	@Test
	public void avgTest() {
		double avg = 5.83;
		double testAvg = service.avg(expenses);
		assertEquals(avg, testAvg, precision);
	}

	@Test
	public void medianTest() {
		// check even length
		double median = 3.675;
		double testMedian = service.median(expenses);
		assertEquals(median, testMedian, precision);
		
		// check odd length
		median = 3.1;
		testMedian = service.median(oddexpenses);
		assertEquals(median, testMedian, precision);
	}

	@Test
	public void highestExpenseCategoryPerUser() {
		// test highest
		Map<User, String> testTotal = service.highestExpenseCategoryPerUser(expenses);
		assertEquals("D", testTotal.get(new User(1, "Dan", "Pickles")));
		assertEquals("A", testTotal.get(new User(2, "Randolph", "Scott")) );
		assertEquals("B", testTotal.get(new User(3, "Howard", "Johnson")));
		
		// test when multiple records in same category
		testTotal = service.highestExpenseCategoryPerUser(moreExpenses);
		assertEquals("A", testTotal.get(new User(1, "Dan", "Pickles")));
		assertEquals("B", testTotal.get(new User(2, "Randolph", "Scott")) );
		assertEquals("B", testTotal.get(new User(3, "Howard", "Johnson")));
	}

}

