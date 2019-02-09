package com.revature.spark.todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.spark.beans.Expense;
import com.revature.spark.beans.User;

/**
 * Within this class, you will implement the logic to calculate data for various
 * reports.
 *
 * @author Dat Tran
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
		for (int i = 0; i < expenses.size(); i++) {
			sum += expenses.get(i).getCost();
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
		double result = 0;
		double temp = Double.MAX_VALUE;
		for (int i = 0; i < expenses.size(); i++) {
			double curr = expenses.get(i).getCost();
			if (curr < temp) {
				result = curr;
				temp = curr;
			}
		}
		return result;
	}

	/**
	 * Find the highest expense cost.
	 *
	 * @param calls
	 * @return
	 */
	public Double max(List<Expense> expenses) {
		double result = 0;
		double temp = Double.MIN_VALUE;
		for (int i = 0; i < expenses.size(); i++) {
			double curr = expenses.get(i).getCost();
			if (curr > temp) {
				result = curr;
				temp = curr;
			}
		}

		return result;
	}

	/**
	 * Find the average expense cost.
	 *
	 * @param calls
	 * @return
	 */
	public Double avg(List<Expense> expenses) {
		double result = 0;
		for (int i = 0; i < expenses.size(); i++) {
			result += expenses.get(i).getCost();
		}
		return result /= expenses.size();
	}

	/**
	 * Find the median expense cost.
	 *
	 * @param calls
	 * @return
	 */
	public Double median(List<Expense> expenses) {
		double myArray[] = new double[100];
		double result = 0;
		for (int i = 0; i < expenses.size(); i++) {
			myArray[i] = expenses.get(i).getCost();
		}

		bubbleSort(myArray);
		reverse(myArray);

		if (expenses.size() % 2 == 0) {
			result = (myArray[(int) Math.floor(expenses.size() / 2 - 1)]
					+ myArray[(int) Math.ceil(expenses.size() / 2)]) / 2;
		} else {
			result = myArray[expenses.size() / 2];
		}

		return result;
	}

	public void bubbleSort(double[] arr) {
		boolean swapped = true;
		int j = 0;
		double tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}

	public void reverse(double[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			double temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
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
		Map<User, String> expensesMap = new HashMap<User, String>();

		User previousUser = expenses.get(0).getUser();
		double maxCost = expenses.get(0).getCost();
		int userIDWithMaxCost = 0;

		for(int i = 1; i < expenses.size(); i++) {
			Expense currentExpense = expenses.get(i);
			User currentUser = currentExpense.getUser();
			double currentCost = currentExpense.getCost();

			if(previousUser.getId() == currentUser.getId()) {
				String previousCategory = expenses.get(i - 1).getCategory();
				String currentCategory = currentExpense.getCategory();

				if(currentCategory.equals(previousCategory)) {
					currentCost = expenses.get(i - 1).getCost() + currentExpense.getCost();
				}

				if(currentCost >= maxCost) {
					userIDWithMaxCost = i;
					maxCost = currentCost;
					expensesMap.put(currentUser, currentExpense.getCategory());
					previousUser = expenses.get(userIDWithMaxCost).getUser();
				}
			} else {
				expensesMap.put(currentUser, currentExpense.getCategory());
				maxCost = currentExpense.getCost();
				previousUser = currentExpense.getUser();
			}
		}

//		System.out.println(expensesMap.toString());

		return expensesMap;

	}
}
