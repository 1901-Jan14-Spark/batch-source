package com.revature.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	static Scanner sc = new Scanner(System.in);
	static int answer = (int) Math.round(Math.random()*100);
	static int guess = 0;
	static int guessCount = 0;
	static int min = 0;
	static int max = 100;
	
	public static void main(String[] args) {
		play();
	}
	
	public static void play() {
		System.out.println("Enter a Number Between "+ min + " and " + max+":");
		try {
			guess = sc.nextInt();
			if(guess <= 100 && guess >=0) {
				guessCount++;
				if(guess < answer) {
					System.out.println("Guess was to low, Try Again!");
					min = guess + 1;
					play();
				}
				else if(guess == answer) {
					System.out.println("Congratulations the Answer: " + guess + " was Found!, In " + guessCount + " Attempts");
				}
				else if (guess > answer) {
					System.out.println("Guess was to high, Try Again!");
					max = guess - 1;
					play();
				}
			}
		}catch(InputMismatchException e){
			System.out.println("Please Enter a Valid Integer Input!");
			play();
		}
//		else if(guess == (int)guess){
//			try {
//				throw new NumberOutOfBoundsException("Number");
//			}catch(NumberOutOfBoundsException e){
//				
//			}
//		}
//		else if(guess != (int)guess){
//			try {
//				throw new NumberOutOfBoundsException("Number");
//			}catch(NumberOutOfBoundsException e){
//				
//			}
	}
}
