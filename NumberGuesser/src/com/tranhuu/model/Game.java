package com.tranhuu.model;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.tranhuu.exceptions.MyOutOfBoundException;

public class Game {

	private int randomNum;
	private int counter;
	private int start;
	private int stop;
	private int myGuess;
	static Scanner sc = new Scanner(System.in);

	public Game() {
		randomNum = (int) (Math.random() * 100);
		counter = 0;
		start = 0;
		stop = 100;
	}

	public int getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}
	
	public int guess() {
		System.out.println("\nPlease enter an integer from " + start +" to "+ stop +".");
		String guess = sc.nextLine();
		Integer tempInt = 0;
		try {
			tempInt = Integer.parseInt(guess);
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid integer.");
			guess();
		}
		try {
			if (tempInt < start || tempInt > stop || myGuess == tempInt) {
				throw new MyOutOfBoundException("Invalid input.");
			}
		} catch (MyOutOfBoundException e) {
			System.out.println("Input needs to be between " + start +" and "+ stop +".");
			return guess();
		}
		myGuess = tempInt;
		System.out.println(myGuess);
		return tempInt.compareTo(randomNum);
	}

	public void notice() {
		int compare = guess();
		counter++;
		System.out.println("\nThis your try number: " + counter + ".");
		if (compare == 1) {
			System.out.println("Your guess is too high.");
			stop = myGuess;
			notice();
		} else if (compare == -1) {
			System.out.println("Your guess is too low.");
			start = myGuess;
			notice();
		} else {
			System.out.println("Congratulations! It only took you " + counter + " tries.");
			return;
		}
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
