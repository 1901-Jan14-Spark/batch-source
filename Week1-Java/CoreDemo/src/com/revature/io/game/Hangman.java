package com.revature.io.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

	
/*
 * Add rules to game:
 * -- input validation DONE
 * -- limit to 6 incorrect guesses DONE
 * -- loop to keep playing upon user request DONE
 * -- case insensitive DONE
 * -- write to a scoreboard DONE
 * -- theme game / separate by difficulty (optional) DONE
 * 
 */


public class Hangman {
	static String wordsFilePath = "src/com/revature/io/game/words.txt";
	static String scoreFilePath = "src/com/revature/io/game/score.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {	
		startGame();
	}
	
	static int getHangmanScore(String string) {
		if (string == null || string.equals(""))
			return -1;
		int result = 0;
		string = string.toLowerCase();
		
		String temp = string;
        temp = temp.replaceAll("[^aeioulnrst]", "");
        result += temp.length();
        temp = string;
        temp = temp.replaceAll("[^dg]", "");
        result += temp.length() * 2;
        temp = string;
        temp = temp.replaceAll("[^bcmp]", "");
        result += temp.length() * 3;
        temp = string;
        temp = temp.replaceAll("[^fhvwy]", "");
        result += temp.length() * 4;
        temp = string;
        temp = temp.replaceAll("[^k]", "");
        result += temp.length() * 5;
        temp = string;
        temp = temp.replaceAll("[^x]", "");
        result += temp.length() * 8;
        temp = string;
        temp = temp.replaceAll("[^qz]", "");
        result += temp.length() * 10;
        
		return result;
	}
	
	static void startGame()
	{
		System.out.println("Welcome to Java Hangman!\n");
		System.out.println("1) Easy");
		System.out.println("2) Medium");
		System.out.println("3) Hard");
		System.out.println("4) Exit");
		int option = 0;
		while(true)
		{
			try
			{
				option = scan.nextInt();
				switch (option)
				{
					case 1:
					{
						guess(getWord(), 12);
					}
					break;
					case 2:
					{
						guess(getWord(), 6);
					}
					break;
					case 3:
					{
						guess(getWord(), 3);
					}
					break;
					case 4:
					{
						System.exit(0);
					}
					break;
					default:
					{
						System.out.println("Invalid input. Try again");
						continue;
					}
				}
			}
			catch (InputMismatchException e)
			{
				scan.nextLine();
				System.out.println("Invalid input. Try again");
				continue;
			}
		}
	}
	
	static void guess(String word, int guessCount) {
		char[] guessed = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";
		while(!String.valueOf(guessed).equals(word)) {
//			clearConsole();
			// print state of guessed array
			if (guessCount == 0)
			{
				System.out.println("\nYou lose! Your word was " + word + ". Would you like to play again?");
				System.out.println("1) Yes");
				System.out.println("2) No");
				int option;
				while(true)
				{
					try
					{
						option = scan.nextInt();
						switch(option)
						{
							case 1:
							{
								startGame();
							}
							break;
							case 2:
							{
								System.exit(0);
							}
							break;
							default:
							{
								System.out.println("Invalid input. Try again");
								continue;
							}
						}
					}
					catch(InputMismatchException e)
					{
						scan.nextLine();
						System.out.println("Invalid input. Try again");
						continue;
					}
				}
			}
			printGuess(guessed);
			
			// use scanner to get the next input from our user
			System.out.print("Guess a letter:");
			if(wrong!="") {
				System.out.println("Your previous wrong guesses are: "+wrong);
			} else {
				System.out.println();
			}
			String letter = scan.nextLine();
			
			while(true)
			{
				letter = letter.toLowerCase();
				if (letter.length() != 1)
				{
					System.out.println("Invalid input. Try again.");
					letter = scan.nextLine();
				}
				else if (letter.matches("[^a-z]"))
				{
					System.out.println("Invalid input. Try again.");
					letter = scan.nextLine();
				}
				else 
					break;
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
				} else {
					System.out.println("Incorrect guess");
					wrong += letter + " ";
					guessCount -= 1;
				}
			}
		}
		System.out.println("\n\n\n\nYou figured out the word! Your word was " + word + ". You scored: " + getHangmanScore(word)+ "\n");
		printToScoreBoard(word, guessCount);
		startGame();
	}
	
	public static void printToScoreBoard(String word, int guessCount)
	{
		System.out.print("Player name: ");
		String player = scan.next();
		try(FileWriter fw = new FileWriter(scoreFilePath, true);
			BufferedWriter bw = new BufferedWriter(fw))
		{
			bw.newLine();
			bw.write("Player:" + player + " Word:" + word + " Score:" + getHangmanScore(word));
		}
		catch (IOException e)
		{
			System.out.println("Write failed!");
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
	
	
//	public static void clearConsole() {
//		for(int i = 0; i<20; i++) {
//			System.out.println();
//		}
//	}

}
