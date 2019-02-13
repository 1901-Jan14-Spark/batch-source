package com.revature.spark.todo;

import java.util.List;
import java.util.Map;

import com.revature.spark.beans.Call;
import com.revature.spark.beans.User;

/**
 * Within this class, you will implement the logic to calculate data for various
 * reports.
 * 
 * @author Thomas Marsden
 * 
 */

public class AssociateImplementation {

	/**
	 * Find the sum of all call times. This is the time all employees have spent on
	 * the phone.
	 * 
	 * @param calls
	 * @return
	 */
	
	public Double sum(List<Call> calls) {
		double call_times = 0;
		for(int i = 0; i < calls.size(); i++) {
			call_times += calls.get(i).getCallTime();
		}
		return call_times;
	}

	/**
	 * Find the lowest call time out of all calls.
	 * 
	 * @param calls
	 * @return
	 */
	
	public Double min(List<Call> calls) {
		double minCallTime = 100; // no call time goes over 100
		for(int i = 0; i < calls.size(); i++) {
			minCallTime = Math.min(minCallTime, calls.get(i).getCallTime());
		}
		return minCallTime;
	}

	/**
	 * Find the highest call time out of all calls.
	 * 
	 * @param calls
	 * @return
	 */
	
	public Double max(List<Call> calls) {
		double maxCallTime = 0; // call time must be > 0
		for(int i = 0; i < calls.size(); i++) {
			maxCallTime = Math.max(maxCallTime, calls.get(i).getCallTime());
		}
		return maxCallTime;
	}

	/**
	 * Find the average call time of all calls.
	 * 
	 * @param calls
	 * @return
	 */
	
	public Double avg(List<Call> calls) {
		double avgCallTime = 0;
		for(int i = 0; i < calls.size(); i++) {
			avgCallTime += calls.get(i).getCallTime();
		}
		
		avgCallTime = avgCallTime/calls.size();
		
		return avgCallTime;
	}
	

	/**
	 * Find the median call time of all calls.
	 * 
	 * @param calls
	 * @return
	 */
	
	public Double median(List<Call> calls) {
		double medCallTime = 199;
		double arrayList[] = new double[calls.size()];
		for(int i = 0; i < calls.size(); i++) {
			arrayList[i] = calls.get(i).getCallTime();
		}
		
		bubbleSort(arrayList);
		reverse(arrayList);

		if(calls.size() % 2 == 0) {
			medCallTime = (arrayList[(int) Math.floor(calls.size()/2 - 1)] + arrayList[(int) Math.ceil(calls.size()/2)])/2;
		}else {
			medCallTime = arrayList[calls.size()/2];
		}
		
		return medCallTime;
	}
	
	public void bubbleSort(double[] array) {
	    boolean swapped = true;
	    int j = 0;
	    double tmp;
	    while (swapped) {
	        swapped = false;
	        j++;
	        for(int i = 0; i < array.length - j; i++) {
	            if(array[i] > array[i + 1]) {
	                tmp = array[i];
	                array[i] = array[i + 1];
	                array[i + 1] = tmp;
	                swapped = true;
	            }
	        }
	    }
	}
	
	public void reverse(double[] array) {
		for(int i = 0; i < array.length / 2; i++)
		{
		    double temp = array[i];
		    array[i] = array[array.length - i - 1];
		    array[array.length - i - 1] = temp;
		}
	}

	/**
	 * !! BONUS CHALLENGE REQUIREMENT !!
	 * 
	 * Find the average call time for each user.
	 * 
	 * @param calls
	 * @return
	 */
	
	public Map<User, Double> avgCallTimePerUser(List<Call> calls) {
		return null;
	}

}
