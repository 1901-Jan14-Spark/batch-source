package com.revature.spark.todo;

import java.util.List;
import java.util.Map;

import com.revature.spark.beans.Expense;
import com.revature.spark.beans.User;

/**
 * Within this class, you will implement the logic to calculate data for various
 * reports.
 * 
 * @author Your Name Here
 * 
 */
public class AssociateImplementation {

	/**
	 * Find the sum of all expenses.
	 * 
	 * @param calls
	 * @return
	 */
	public Double sum(List<Expense> expenses) {
		double sum = 0;
		for(Expense i : expenses) {
			sum+= i.getCost();
		}
		return sum;
	}

	/**
	 * Find the lowest expense cost.
	 * 
	 * @param calls
	 * @return
	 */
	public Double min(List<Expense> expenses) {
		double min = Double.MAX_VALUE;
		for(Expense i : expenses) {
			if(min > i.getCost()) {
				min = i.getCost();
			}
		}
		return min;
	}

	/**
	 * Find the highest expense cost.
	 * 
	 * @param calls
	 * @return
	 */
	public Double max(List<Expense> expenses) {	
		double max = 0;
		for(Expense i : expenses) {
			if(max < i.getCost()) {
				max = i.getCost();
			}
		}
		return max;
	}

	/**
	 * Find the average expense cost.
	 * 
	 * @param calls
	 * @return
	 */
	public Double avg(List<Expense> expenses) {
		double sum = 0;
		for(Expense i : expenses) {
			sum+= i.getCost();
		}
		return sum/expenses.size();
	}

	/**
	 * Find the median expense cost.
	 * 
	 * @param calls
	 * @return
	 */
	public Double median(List<Expense> expenses) {
		double[] medianArray = new double[expenses.size()];
		int count = 0;
		for(Expense i : expenses) {
			medianArray[count] = i.getCost();
			count++;
		}
		int size = expenses.size();
		for(int i = 0; i < size - 1; i++) {
			for(int j = 0; j < size - i - 1; j++) {
				if(medianArray[j] > medianArray[j+1]) {
					double temp = medianArray[j];
					medianArray[j] = medianArray[j+1];
					medianArray[j+1] = temp;
				}
			}
		}
//		for(int i= 0; i < medianArray.length; i++) {
//			System.out.print(medianArray[i] + ", ");
//		}

		if(medianArray.length%2 == 0) {
			double medianValue = 0;
			medianValue = (medianArray[medianArray.length/2] + medianArray[(medianArray.length/2)-1])/2;
			return medianValue;
			
		}
		else {
			double medianValue = 0;
			medianValue = medianArray[medianArray.length/2];
			return medianValue;
		}
	}

	/**
	 * !! BONUS CHALLENGE REQUIREMENT !!
	 * 
	 * Find the highest expense category for each user.
	 * 
	 * @param calls
	 * @return
	 */
	public Map<User, String> highestExpenseCategoryPerUser(List<Expense> expenses) {
		return null;
	}

}
