package com.revature.io.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	static int highScore;
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Java Hangman.");
		guess(getWord());
	}
	
	//String username = (firstName.charAt(0)+lastName).toLowerCase();
	static void guess(String word) {
		

		
		char[] guessed = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";
		
		while(!String.valueOf(guessed).equals(word)) {
//			clearConsole();
			// print state of guessed array
			printGuess(guessed);
			
			// use scanner to get the next input from our user
			System.out.print("Guess a letter:");
			if(wrong!="") {
				System.out.println("Your previous wrong guesses are: "+wrong);
			} else {
				System.out.println();
			}
			String letter = scan.nextLine();
			letter = letter.toLowerCase(); //convert all to lower 
			
			
			
			//check if entry contains letters or blank space 
			if (!Character.isLetter(letter.charAt(0)) || letter.contains(" ")) {
				
        System.out.println("Not a valid entry");
        
        try {
			    while (!Character.isLetter(letter.charAt(0))) {
			    	
		    System.out.println(" please enter a letter. ");
			        letter = scan.nextLine(); // 
			        letter = letter.toLowerCase(); //convert all to lower 
			    }
			    
             	System.out.println("Thank you! Got it " );
			}catch (StringIndexOutOfBoundsException siobe) {
				
				System.out.println("invalid input");
				
			}
			
			
			} 
			
			
			
			
			
			
			
			if(wrong.contains(letter)) {
				System.out.println("Guessed already!");
				
				//check the number of entry and decidif game should be over
				if (wrong.length() >=6 ) {
					System.out.println(":( Game Over!:(  \n resetting...");
					guess(getWord());
				}
				
				
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
				}
			}

		}
		System.out.println("Success! Word was "+word);
		 highScore++; //increase high score 
		 keepHighScore(); //persist high score
		 replayChoice();
		
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

	// give the player choices 
	 public static void replayChoice() {
		 System.out.println("all time high score =" + highScore + "\n");
		 System.out.println("Press x to play next stage or press any other"
		 		+ "button to exit ");
		 String choice = scan.nextLine();
		 if ( choice.contains("x") ||choice.contains("X")) {
			 
			
			 System.out.println("Restarting...\n");
			 System.out.println("Welcome to Java Hangman.");
				guess(getWord());
			 
		 }
		 else {
			 
			 System.out.println("Game exiting...");
			 System.exit(0); 
		 }
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
 public static boolean keepHighScore() {
	 
	 
		String path = "src/com/revature/io/game/scoreCount.txt";
				
	try (BufferedReader br = new BufferedReader(new FileReader(path))){
				
					String line = br.readLine();
					int scoreonFile;
					if(line!=null && line.matches("^\\d+$")) {
						scoreonFile = Integer.parseInt(line);
						
					} else {
						
						scoreonFile = 0;
					}
					if (scoreonFile > highScore) {//do nothing    
					}
					else {highScore++;
					}
					
					try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
						bw.write(String.valueOf(highScore));
						return true;
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("file not found :( \n ...but, creating it for you :)");
				
				
					 FileOutputStream fout = null;
			
					
					 try {
						fout = new FileOutputStream("src/com/revature/io/game/scoreCount.txt");
						keepHighScore();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				
				return false;
			}
			
	 
	 
	 
	 
	 
	
}
