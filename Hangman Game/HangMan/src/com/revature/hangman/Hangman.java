package com.revature.hangman;

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
	static String wordsFilePath = "src/com/revature/hangman/words.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static String path = "src/com/revature/hangman/Scores.txt"; 
	static String content;
	
	public static void main(String[] args) {
		System.out.println("Welcome to Java Hangman.");
		guess(getWord());
	}
	
	
	static void guess(String word) {
		char[] guessed = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";
		
		while(!String.valueOf(guessed).equals(word)) {
//			
			
			
			
			
			//clearConsole();
			// print state of guessed array
			printGuess(guessed);
			
			// use scanner to get the next input from our user
			
			System.out.print("Guess a letter:");
			if(wrong!="") {
				System.out.println("Your previous wrong guesses are: "+wrong);
			} else {
				System.out.println();
			}
			//input Sanitation
			String letter = scan.nextLine();
			if(letter.matches("[a-zA-Z]")==false) {
				System.out.println("Please enter a single letter");
				continue;
			}
			letter=letter.toLowerCase();
			if(letter.length()>1) {
				System.out.println("Please only one letter at a time");
				continue;
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
				}
			}
			//More than 6 guesses
				if(wrong.length()>10) {
				
				break;}
		}
		
		//Win Screen
		if(wrong.length()<=10) {
		System.out.println("Success! Word was "+word);
		System.out.println("Would you like to enter your score? Y/N");
		  		String reply=scan.nextLine();
		  		String name;
		  		if(reply.contentEquals("Y")) {
		  			System.out.println("Please enter name");
		  			name=scan.nextLine();
		  			content="Name: " + name +"  ***  Word: " + word + "  ***  Incorrect guesses: " + Integer.toString(wrong.length()/2)+"\n";
		  			try(FileWriter fw = new FileWriter(path,true); BufferedWriter bw = new BufferedWriter(fw)){
		  				
		  				bw.append(content);
		  				System.out.println("Your score has been entered:" + content);
		  				
		  			} catch (IOException e) {
		  				e.printStackTrace();
		  			}			
		  			System.out.println("Would you like to play again? Y/N");
					String answer=scan.nextLine();
					boolean YN=false;
					while(YN==false) {
						//replay
						if (answer.equals("Y")) {
							YN=true;
							guess(getWord());
						}//Game Over
						if (answer.equals("N")) {
							YN=true;
							System.out.println("GAME OVER!");
							break;
						}else {
							System.out.println("Please enter Y or N");
							 answer=scan.nextLine();
						
					}
					}			
		  		}else {System.out.println("Would you like to play again? Y/N");
				String answer=scan.nextLine();
				boolean YN=false;
				while(YN==false) {
					//replay
					if (answer.equals("Y")) {
						YN=true;
						guess(getWord());
					}//Game Over
					if (answer.equals("N")) {
						YN=true;
						System.out.println("GAME OVER!");
						break;
					}else {
						System.out.println("Please enter Y or N");
						 answer=scan.nextLine();
					
				}
		  			
		  			
		  			
		  			
		  			
		  		}
		//Lose Screen
		}
		}else {
			System.out.println("Sorry, you only get 6 guesses.");
			System.out.println("Would you like to play again? Y/N");
			String answer=scan.nextLine();
			boolean YN=false;
			while(YN==false) {
				//replay
				if (answer.equals("Y")) {
					YN=true;
					guess(getWord());
				}//Game Over
				if (answer.equals("N")) {
					YN=true;
					System.out.println("GAME OVER!");
					break;
				}else {
					System.out.println("Please enter Y or N");
					 answer=scan.nextLine();
				
			}
			}
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
}
	
//	public static void clearConsole() {
//		for(int i = 0; i<20; i++) {
//			System.out.println();
//		}
//	}
