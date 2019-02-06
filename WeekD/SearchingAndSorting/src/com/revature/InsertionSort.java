package com.revature;

import java.util.Arrays;

public class InsertionSort {
	
	
	public static int[] insertionSort(int[] arr) {
		// we want to iterate through our array until we find an index 
		// with a smaller value than the index to the left 
		int temp = 0;
		for(int i = 1; i<arr.length; i++) {
			if(arr[i]<arr[i-1]) { 
				// if this condition is met, we need to move arr[i] over to its appropriate spot
				// we set our placeholder to the value in question
				System.out.println(Arrays.toString(arr));
				temp = arr[i];
				arr[i] = arr[i-1];
				// we set up a loop to see if any other values need to be moved
				for(int j=i-1;j>=0;j--) {
					if(j==0) {
						arr[j] = temp;
					} else {
						// if temp is greater than the next value on the left, we place the value there
						if(temp>arr[j-1]) {
							arr[j] = temp;
							break;
						// otherwise, we continue to shuffle our values to the right until we find the correct spot
						} else {
							arr[j] = arr[j-1];
						}
					}
				}
			}
		}
		return arr;
		
	}
	

	public static void main(String[] args) {
		int[] myArr = new int[]{2,5,7,3,2,1};
		System.out.println(Arrays.toString(insertionSort(myArr)));
	}

}
