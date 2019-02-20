package com.revature.io.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Add rules to game:
 * -- input validation
 * -- limit to 6 incorrect guesses
 * -- loop to keep playing upon user request after game has ended.
 * -- case insensitive
 * -- write to a scoreboard
 * -- theme game / separate by difficulty (optional)
 */

public class Hangman 
{
	static String wordsFilePath = "src/com/revature/io/game/words.txt";
	static String winnersFilePath = "src/com/revature/io/game/winners.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static int difficulty = 0;
	
	public static void main(String[] args)
	{
			setDifficulty();
	}
	
	static void setDifficulty()
	{
			try{
				System.out.println("Welcome to Java Hangman! Please input your desired level of difficulty. 1 for Easy Mode, 2 for Hard Mode.");
				String diffInput = scan.next();
				if (diffInput.matches("[1-2]"))
				{
					difficulty = Integer.parseInt(diffInput);
					initializeGame(difficulty);
				} else {
					setDifficulty();
				}
			} catch (InputMismatchException e)
			{
				System.out.println("You did not select a valid difficulty... Please restart the application.");
			} 
	}

	static void initializeGame(int difficulty)
	{
		guess(getWord(difficulty));
	}
	
	static void guess(String word)
	{
		char[] guessed = new char[word.length()];
		for(int i = 0; i < word.length(); i++)
		{
			guessed[i] = '_';
		}
		String wrong = "";
		
		while(!String.valueOf(guessed).equals(word))
		{
			//print state of guessed array
			printGuess(guessed);
			//use scanner to get the next input from our user
			System.out.println("Guess a letter:");
			if(wrong!="")
			{
				System.out.println("Your previous guesses are: "+wrong);
				//Allowing for only 6 guesses.
				String[] wrongCheck = wrong.split(" ");
				if (wrongCheck.length == 6)
				{
					System.out.println("You LOSE. THE GAME IS OVER. Your word was: "+word);
					replayGameOption();
				}
			} else 
			{
				System.out.println();
			}
			
			//Altered the scan.nextLine() to immediately convert any input letter to be converted to lowercase.
			try
			{
				String letter = scan.next().toLowerCase();
				//Some input sanitization to start -- the letter can accept either uppercase or lowercase letters via this RegEx expression, we know it's all being
				//converted to lowercase for simplicity. If it doesnt match a lower/uppercase letter it will give the user a notification via an exception.
				if(!letter.matches("[A-Za-z]"))
				{
					throw new InputMismatchException();
				}
				
				//match input in word - if present, add to guessed in the proper location 
				if(wrong.contains(letter))
				{
					System.out.println("Guessed already!");
				} else
				{
					if (word.contains(letter))
					{
						for(int i=0; i<word.length(); i++)
						{
							if(word.charAt(i)==letter.charAt(0))
							{
								guessed[i] = letter.charAt(0);
							}
						}
					}  	else
						{
						System.out.println("Incorrect guess.");
						wrong += letter + " ";
						}
				}
			} catch (InputMismatchException e)
			{
				System.out.println("Doh! You broke the game silly, you can't input numbers or more than one letter in this form of hangman! Guess again!");
			}
			
		}
			//If successfully beaten the game -- write the winner to the winner list.
			System.out.println(">>>>>>> SUCCESS! Your word was '"+word+"' <<<<<<<");
			System.out.println("Enter your first name below, we'll add you to our winners list!");
			String playerName = scan.next();
			writeWinners(playerName);
			replayGameOption();
	}
	
	//A method to restart the game if player loses or wins. Gives them the option to input Yy to keep going. 
	//If the user enters anything else the program will forcibly quit.
	public static void replayGameOption()
	{
		System.out.println("Would you like to play again? Input Y for yes, entering anything else will quit the game.");
		String confirmation = scan.next();
		if (confirmation.matches("[Yy]"))
		{
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("Welcome to Java Hangman! Please input your desired level of difficulty. 1 for Easy Mode, 2 for Hard Mode");
			difficulty = scan.nextInt();
			initializeGame(difficulty);
		} else {
			System.out.println("It seems that you have declined the option to play again... goodbye. If you do wish to play again, please re-run the application.");
			System.exit(0);
		}
	}
	
	public static boolean writeWinners(String name)
	{
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(winnersFilePath, true))))
		{
			out.println(name);
			System.out.println("You have been added to our winners list!");
			return true;
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static void printGuess(char[] letters)
	{
		System.out.print("Guessed: ");
		for(char c: letters)
		{
			System.out.print(c+ " ");
		}
		System.out.println();
	}
	
	//getWord method returns a random word from our words.txt file
	static String getWord(int difficulty)
	{
		try(BufferedReader br = new BufferedReader(new FileReader(wordsFilePath)))
		{
			String line = br.readLine();
			while (line != null)
			{
				words.add(line);
				line = br.readLine();
			}
			int randomIndex = (int) (Math.random()*words.size());
			try 
			{
				if (difficulty == 2) 
				{
					while (words.get(randomIndex).length() >= 6)
						{
							String hardWord = words.get(randomIndex);
							return hardWord;
						}
					if (words.get(randomIndex).length() < 6)
					{
						return getWord(difficulty);	
					}
				} 
				if (difficulty == 1)
				{
					while (words.get(randomIndex).length() < 6)	
						{
							String easyWord = words.get(randomIndex);
							return easyWord;
						}
					if (words.get(randomIndex).length() >= 6)
					{
						return getWord(difficulty);	
					}
				}
			} catch (NullPointerException e)
			{
				getWord(difficulty);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
