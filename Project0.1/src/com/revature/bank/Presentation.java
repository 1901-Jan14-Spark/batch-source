package com.revature.bank;

public class Presentation {
	
	public static void main(String[] args) {
		
		System.out.println(reverse("Milk Man"));

	}
	
	public static String reverse(String string) {
		char[] word = string.toCharArray();
		char[] reverse = new char[word.length];
		int posIndex = 0;
		String reverseWord ="";
		
		
		for(int i = word.length - 1; i >= 0; i--) {
			reverse[posIndex] = word[i];
			posIndex++;
		}
		
		for(char c : reverse) {
			reverseWord += c;
		}	
		return reverseWord;
	}
	
}
