package com.revature;

import java.util.Scanner;

public class Game {
	
	// static scanner to be used within the game
	private static Scanner s = new Scanner(System.in);

	// instance variable to keep track of the number of times the user guesses
	private int count = 0;
	
	// instance variables 
	private int lowerLim = 0;
	private int upperLim = 100;
	
	// randomly generated value for each instance
	private int generatedNum = (int) (Math.random()*upperLim);
	
	// a variable to hold the value of each guess, initialized at -1 so as to still allow for guesses when generatedNum is 0
	private int currentGuess = -1;
	
	public Game() {
		super();
	}
	
	// allows us to configure game for different ranges
	public Game(int lowerLim, int upperLim) {
		this.lowerLim = lowerLim;
		this.upperLim = upperLim;
	}
	
	public void play() {
		System.out.println("Welcome to the guessing game!");
		while(currentGuess != generatedNum) {
			currentGuess = getGuess();
			if(currentGuess>generatedNum) {
				System.out.println("Too high, try again!");
				upperLim = currentGuess;
			} else if(currentGuess<generatedNum){
				System.out.println("Too low, try again!");
				lowerLim = currentGuess;
			}
		} 
		System.out.println("You guessed correctly!");
		System.out.println("Took you "+count+" guesses");
		s.close();
	}
	
	public int getGuess() {
		System.out.println("Enter your guess between "+lowerLim+" and "+upperLim+":");
		String rawInput = s.nextLine();
		if(rawInput.matches("^\\d+$")) {
			int numInput = Integer.parseInt(rawInput);	
			if(numInput>lowerLim && numInput<upperLim) {
				count++;
				return Integer.parseInt(rawInput);				
			} else {
				System.out.println("Guess out of range.");
				return getGuess();
			}

		} else {
			System.out.println("Invalid input, try again.");
			return getGuess();	
		}
	}
}
