package com.revature;

public class BinarySearch {
	
	public static int search(int[] arr, int val, int start, int end) {
		if(end>=start) {
			int mid = ((end-start)/2)+start;
			
			if(arr[mid] == val) {
				return mid;
			}
			
			if(arr[mid]>val) {
				return search(arr, val, start, mid-1);
			}
			
			if(arr[mid]<val) {
				return search(arr, val, mid+1, end);
			}
			
		}
		return -1;
	}
	
	public static int search(int[] arr, int value) {
		return search(arr,value,0,arr.length);
	}
	

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,5,7,9,12,15,18,20};
//		System.out.println(search(arr,9,0,arr.length));
		System.out.println(search(arr,20));


	}

}
