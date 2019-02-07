package com.revature;

import java.util.Arrays;

public class SelectionSort {

	public static int[] selectionSort2(int[] arr) {
		return null;
	}
	
	public static int[] selectionSort(int[] arr) {
		int n =(arr==null)?0:arr.length;
		if(n == 0) {
			return arr;
		}
		
		for(int i=0; i<n; i++) {
			int minPosition = i;
			int temp;
			for(int j=i; j<n; j++) {
				if(arr[j]<arr[minPosition]) {
					minPosition = j;
				} 
			}
			temp = arr[minPosition];
			arr[minPosition] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {8,5,8,2,1,3,5};
		System.out.println(Arrays.toString(selectionSort(arr)));

	}

}
