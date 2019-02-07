package com.revature;

import java.util.Arrays;

public class MergeSortDemo {
	
	public static void main(String[] arg) {
		int[] myArr = new int[] {4,7,2,7,8,2,1};
		String arrayString = Arrays.toString(mergeSort(myArr));
		System.out.println(arrayString);
	}
	
	/*
	 * 1. if length is 1 or less, we return the array
	 * 2. otherwise split array
	 * 3. apply merge sort to left half 
	 * 4. apply merge sort to right half 
	 * 5. merge our two sorted arrays back together
	 * 
	 */
	
	public static int[] mergeSort(int[] arr) {
		
		// step one - check length of array
		if(arr.length < 2) {
			return arr;
		}
		
		// step two - split our array 
		int midpoint = arr.length/2;
		int[] left = new int[midpoint];
		int[] right = new int[arr.length - midpoint];
		
		
		// populate our left and right arrays accordingly
		for(int i = 0; i<midpoint; i++) {
			left[i] = arr[i];
		}
		
		for(int j = 0; j<right.length;j++) {
			right[j] = arr[midpoint+j];
		}
		
		// apply merge sort to left half 
		left = mergeSort(left);
		
		// apply merge sort to right half
		right = mergeSort(right);
		
		int[] result = new int[arr.length];
		
		// merge our left and right arrays together
		result = merge(left, right);
		
		return result;
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		
		int leftPointer = 0;
		int rightPointer = 0;
		int resultPointer = 0;
		
		// checking if there are any values left in either array
		while(leftPointer<left.length || rightPointer<right.length) {
			// checking if there are values left in both arrays
			if(leftPointer<left.length && rightPointer<right.length) {
				if(left[leftPointer]<right[rightPointer]) {
					result[resultPointer] = left[leftPointer];
					leftPointer++;
					resultPointer++;
				} else {
					result[resultPointer] = right[rightPointer];
					rightPointer++;
					resultPointer++;
				}
			} else if (leftPointer<left.length) {
				result[resultPointer] = left[leftPointer];
				resultPointer++;
				leftPointer++;
			} else if (rightPointer<right.length) {
//				result[resultPointer++] = right[rightPointer++];
				result[resultPointer] = right[rightPointer];
				resultPointer++;
				rightPointer++;
			}
		}
		return result; 
	}

}
