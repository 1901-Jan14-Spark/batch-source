package com.revature.io.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * Add rules to game
 * -- input validation
 * -- limit to 6 incorrect guesses
 * -- loop to keep playing upon user request
 * -- case insensitive
 * -- write to a scoreboard
 * -- theme game / separate by difficulty (optional)
 * 
 */

public class Hangman {
	static String scoreboardPath = "src/com/revature/io/game/scoreboard.txt";
	static String wordsFilePath = "src/com/revature/io/game/words.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static String legalInput = "abcdefghijklmnopqrstuvwxyz"; // a string version of the only possible guess values

	public static void main(String[] args) {
		System.out.println("Welcome to Java Hangman.");
		System.out.println();
		System.out.println();
		guess(getWord());
		
	}
	
	static void guess(String word) {	
		// a userName that will be linked with the score for the current player
		System.out.println("Please enter username: ");
		String userName = scan.nextLine();
		System.out.println("Select your difficulty: Easy - Medium - Hard");
		String diff = scan.nextLine();
		int numOfGuesses = 6;  // the original number of guess that will be overridden based on the difficulty
		int diffMod = 0;
		// the number guessed allowed if determined by the difficulty of the game
		if (diff.equals("Easy".toLowerCase()) || diff.equals("Easy")) {
			diffMod = 1;
			numOfGuesses = 10; // 10 guesses on easy wiht a 1 times modifier
		} else if (diff.equals("Medium".toLowerCase()) || diff.equals("Medium")) {
			diffMod = (int) 1.5;
			numOfGuesses = 7; // 7 guesses on medium with a 1.5 times modifier
		} else if (diff.equals("Hard".toLowerCase()) || diff.equals("Hard")) {
			diffMod = 2;
			numOfGuesses = 3; // only three guesses on hard but double the points!
		} else {
			System.out.println("Please select a valid difficulty!");
		}
		
		int score = 0; // will be used to hold the player's final score
		String userData = ""; // the string used to hold the player's name and score that will be written to the scoreboard file
		
		char[] guessed = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";
			
		// the game will run as long as the user has guesses remaining	
		while(!String.valueOf(guessed).equals(word) && numOfGuesses > 0) {
			// print state of guessed array
			printGuess(guessed);		
			// use scanner to get the next input from our user
			System.out.println("Guesses Remaining: " + numOfGuesses);
			if(wrong != "") {
				System.out.println("Your previous guesses are: " + wrong);
				System.out.println("Guess a letter: ");
			} else {
				System.out.println("Guess a letter: ");
			}
			String letter = scan.next().toLowerCase();	
			
			// check the user input to make sure it is a valid letter that has been designated within the legalInput String
			//if not, ask the user to re-enter a letter
			if(!legalInput.contains(letter) || letter.length() > 1) {
				System.out.println("Please enter valid a letter:");
				// this scanner forces 
				letter = scan.next().toLowerCase();
			}
			
					
			if(wrong.contains(letter)) {
				System.out.println("Guessed already!");
			} else {
				// match input in word - if present, add to guessed in the proper location
				if(word.contains(letter)) {
					for(int i = 0; i < word.length(); i++) {
						if(word.charAt(i) == letter.charAt(0)) {
							guessed[i] = letter.charAt(0);	
							// add 15 points for each correct letter the user guesses
							for(char c : guessed) {
								if(c != '_') {
									score += 15;
								}
							}
						}
					}
				} else {
					System.out.println("Incorrect guess");
					numOfGuesses--; // reduce the amount of guesses after each guess
					wrong += letter + " ";
				}
			}
		}
		// message ad final score if the player does not guess the word and runs out of guesses
		if(numOfGuesses == 0 && !String.valueOf(guessed).equals(word)){
			System.out.println();
			System.out.println("You lose! Your word was: " + word + "\nBetter luck net time :(");
			// form a String object of the players name and final score
			userData = userName + " on " + diff + " score: " + (score * diffMod);
			postScore(userData); // call the post method to put the score on the scoreboard
			playAgain(); // see if the user wants to play again
		} else {
			System.out.println();
			System.out.println("Success! Word was " + word); // inform the user of what their word was
			score += 50; // 50 extra points for guessing the correct word
			userData = userName + " on " + diff + " score: " + (score * diffMod); 
			postScore(userData);
			playAgain();
		}
	}
	
	// method to decide if the player would like to play again
	public static void playAgain() {
		System.out.println();
		System.out.println("Would you like to play again?");
		String answer = scan.next().toLowerCase(); // players answer
		if(answer.equals("Yes".toLowerCase()) || answer.equals("Y".toLowerCase())) {
			guess(getWord()); // call the game again
		} else {
			System.out.println();
			System.out.println("Thanks for playing!");
		}
		
	}
	
	public static void printGuess(char[] letters) {
		System.out.println("Guessed: ");
		for(char c : letters) {
			System.out.print(c + " ");
		}
		System.out.println();	
	}
	
	// getWord method returns a random word from our words file
	static String getWord() {	
		try(BufferedReader br = new BufferedReader(new FileReader(wordsFilePath))){
			String line = br.readLine();
			while(line != null) {
				words.add(line);
				line = br.readLine();
			}
			int randomIndex = (int) (Math.random()*words.size());
			return words.get(randomIndex);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// scoreboard writer that take one string argument, the score the user got
	public static void postScore(String score) {
		try(FileWriter fw = new FileWriter(scoreboardPath, true); // add the new data to he existing data
				BufferedWriter bw = new BufferedWriter(fw)){
			bw.newLine(); // adds the user data on a new line
			bw.append(score); // 
			System.out.println();
			System.out.println("Your score has been posted!");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
