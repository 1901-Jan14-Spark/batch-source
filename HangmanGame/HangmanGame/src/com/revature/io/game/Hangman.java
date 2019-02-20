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
 * Add rules to game:
 * -- input validation
 * -- limit to 6 incorrect guesses
 * -- loop to keep playing upon user request
 * -- case insensitive
 * -- write to a scoreboard
 * -- theme game / separate by difficulty (optional)
 * 
 */


public class Hangman {
	static String wordsFilePath = "src/com/revature/io/game/words.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static String alphabetString = "abcdefghijklmnopqrstuvwxyz";
	static String path = "src/com/revature/io/game/scoreboard.txt";
	public static void main(String[] args) {
		System.out.println("Welcome to Java Hangman.");
		guess(getWord());
	}
	
	
	static void guess(String word) {
		String scoreInfo = "";
		String playerName = "";
		int score = 0;
		int numOfGuesses = 6;
		String difficulty = "Easy";
		double scoreMultiplier = 0;
		
		System.out.println("Enter Player Name: ");
		playerName = scan.nextLine();
		
		System.out.println("Choose Your Difficulty: Easy/Normal/Hard/");
		difficulty = scan.nextLine().trim().toLowerCase();
		if(difficulty.contentEquals("easy")){
			scoreMultiplier = 0.5;
			numOfGuesses = 10;
		}
		else if(difficulty.contentEquals("normal")) {
			scoreMultiplier = 1.0;
			numOfGuesses = 5;
		}
		else if(difficulty.contentEquals("hard")) {
			scoreMultiplier = 2.0;
			numOfGuesses = 2;
		}
		
		char[] guessed = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";
		while(!String.valueOf(guessed).equals(word) && numOfGuesses != 0) {
//			clearConsole();
			// print state of guessed array
			printGuess(guessed);
			
			// use scanner to get the next input from our user
			System.out.println("Remaining Guesses: " + numOfGuesses);
			System.out.println("Guess a letter:");
			if(wrong!="") {
				System.out.println("Your previous wrong guesses are: "+wrong);
			} else {
				System.out.println();
			}
			String letter = scan.nextLine().trim().toLowerCase();
//			System.out.println(letter.length());
			//check to see if the scanned input is a letter based off of a characters in the alphabet array, anything else will give an error
			if(!alphabetString.contains(letter) || letter.length() != 1) {
				System.out.println("Please enter a Valid character from the alphabet:");
				letter = scan.nextLine().toLowerCase();
			}
			if(wrong.contains(letter)) {
				System.out.println("Guessed already!");
			} else {
				// match input in word - if present, add to guessed in the proper location 
				if(word.contains(letter)) {
					for(int i=0; i<word.length();i++) {
						if(word.charAt(i)==letter.charAt(0)) {
							guessed[i] = letter.charAt(0);
						}
					}
					score += 10;
				} else {
					System.out.println("Incorrect guess");
					wrong += letter + " ";
					numOfGuesses--;
				}
			}

		}
		if(!String.valueOf(guessed).equals(word) && numOfGuesses == 0) {
			System.out.println("To Bad you lose the Game!");
			scoreMultiplier *= score;
			scoreInfo = playerName + " ("+difficulty+"): "+ scoreMultiplier;
			System.out.println(scoreInfo);
			scorePost(scoreInfo);
			playAgain();
			
		}
		else {
		System.out.println("Success! Word was "+word + "With "+numOfGuesses+" Guesses Remaining");
		score += 100;
		scoreMultiplier *= score;
		scoreInfo = playerName + " ("+difficulty+"): "+ scoreMultiplier;
		System.out.println(scoreInfo);
		scorePost(scoreInfo);
		playAgain();
		}
	}
	
	public static void printGuess(char[] letters) {
		System.out.print("Guessed: ");
		for(char c: letters) {
			System.out.print(c+ " ");
		}
		System.out.println();
	}
	
	// getWord method returns a random word from our words file
	static String getWord() {
		try(BufferedReader br = new BufferedReader(new FileReader(wordsFilePath))){
			String line = br.readLine();
			while(line!=null) {
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
	
	public static void playAgain() {
		System.out.println();
		System.out.println("Do you want to Play Again? Yes/No");
		String answer = scan.nextLine().trim().toLowerCase();
		if(answer.equals("yes")) {
			System.out.println();
			guess(getWord());
		}
		else {
			System.out.println();
			System.out.println("Thanks for Playing");
		}
	}
	public static void scorePost(String score) {
		try(FileWriter fw = new FileWriter(path, true); BufferedWriter bw = new BufferedWriter(fw)){
			bw.newLine();
			bw.append(score);
			System.out.println("Score Posted");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String add(String content) {
		int value = Integer.parseInt(content);
		value++;
		String strValue = Integer.toString(value);
		return strValue;
	}

}