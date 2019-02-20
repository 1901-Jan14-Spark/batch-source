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
	static String easyWordsFilePath = "src/com/revature/io/game/easyWords.txt";
	static String hardWordsFilePath = "src/com/revature/io/game/hardWords.txt";
	static String scoreBoardPath = "src/com/revature/io/game/scoreBoard.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static int wrongGuessCounter = 0;
	static boolean keepPlaying = true;
	
	public static void main(String[] args) {
		System.out.println("Welcome to Java Hangman.");

		// do while loop to allow continuous game play upon user request
		while(keepPlaying) {
			System.out.println("Please pick a difficulty level");
			System.out.println("[Easy, Medium, Hard]");
			String difficultyInput = scan.nextLine().toLowerCase();
			if(difficultyInput.equals("easy")) {
				System.out.println("****************************************");
				System.out.println("Game begin, now loading easy hangman words");
				guess(getWord(easyWordsFilePath));
			} else if (difficultyInput.equals("medium")) {
				System.out.println("****************************************");
				System.out.println("Game begin, now loading medium hangman words");
				guess(getWord(wordsFilePath));
			} else if (difficultyInput.equals("hard")) {
				System.out.println("****************************************");
				System.out.println("Game begin, now loading hard hangman words");
				guess(getWord(hardWordsFilePath));
			}		
			System.out.println("Play again?");
			String input = scan.nextLine().toLowerCase();
			if(input.equals("no")) {
				keepPlaying = false;
			}
		}
		System.out.println("Goodbye");
	}
	
	
	static void guess(String word) {
		char[] guessed = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";
		
		
		while(!String.valueOf(guessed).equals(word) && wrongGuessCounter < 6) {
//			clearConsole();
			// print state of guessed array
			printGuess(guessed);
			
			// use scanner to get the next input from our user
			System.out.print("Guess a letter:");
			if(wrong!="") {
				System.out.println(" Your previous wrong guesses are: "+wrong);
			} else {
				System.out.println();
			}
			String letter = scan.nextLine().toLowerCase();
			if (letter.length() == 1) {
				if(wrong.contains(letter)) {
					System.out.println();
					System.out.println("Guessed already!");
				} else {
					// match input in word - if present, add to guessed in the proper location 
					if(word.contains(letter)) {
						for(int i=0; i<word.length();i++) {
							if(word.charAt(i)==letter.charAt(0)) {
								guessed[i] = letter.charAt(0);
							}
						}
					} else {
						System.out.println();
				        System.out.println("*************************************************************");
						System.out.println("Incorrect guess");
						// increment number of wrong guess by 1
						wrongGuessCounter++;
						System.out.println("You have " + (6 - wrongGuessCounter) + " guesses remainding");
						wrong += letter + " ";
					}
				}
			} else {
				System.out.println();
				System.out.println("Please only enter 1 character at a time");
			}
		}
		if (wrongGuessCounter == 6) {
			System.out.println("Fail! Word was " + word);
			writeToScoreBoard(word, guessed, wrong);
		} else {
			System.out.println("Success! Word was " + word);
			writeToScoreBoard(word, guessed, wrong);
		}
		wrongGuessCounter = 0;
	}
	
	public static void printGuess(char[] letters) {
		System.out.print("Guessed: ");
		for(char c: letters) {
			System.out.print(c+ " ");
		}
		System.out.println();
	}
	
	// getWord method returns a random word from our words file
	static String getWord(String diffulty) {
		try(BufferedReader br = new BufferedReader(new FileReader(diffulty))){
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
	
	// writeToScoreBoard method create a score board in our scoreBoard.txt file
	static void writeToScoreBoard(String word, char[] guessed, String wrong) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(scoreBoardPath))){
			
			bw.write("Word: " + word);
			bw.write("\nGuessed: ");
			for(char c : guessed) {
				bw.write(c);
			}
			bw.write("\nWrong guesses: " + wrong);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void chooseDifficulty(String level) {
		
	}
	
	
//	public static void clearConsole() {  
//		
//    }

}