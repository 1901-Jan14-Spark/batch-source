package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		int count=0;
		while(!String.valueOf(guessed).equals(word)) 
		{
//			clearConsole();
			// print state of guessed array
			printGuess(guessed);
			// use scanner to get the next input from our user
			System.out.print("Guess a letter:");
			if(wrong!="") {
				count++;
				System.out.println("Your previous wrong guesses are: "+wrong);
			} else {
				System.out.println();
			}
			String letter = scan.nextLine().toLowerCase(); //case insensitive
			
			if(wrong.contains(letter)) {
				System.out.println("Guessed already!");
			} 
			
			 // -- input validation
			if(!letter.matches("[a-z]")) {
				System.out.println("Invalid input, inser a letter between a to z");
			}
			else {
				// match input in word - if present, add to guessed in the proper location 
				if(word.contains(letter)) {
					for(int i=0; i<word.length();i++) {
						if(word.charAt(i)==letter.charAt(0)) {
							guessed[i] = letter.charAt(0);
						}
					}
				} 
				//-- limit to 6 incorrect guesses
				else if(count >= 6 ) {
					System.out.println("Game Over! Word was "+word);
					break;
				}
				else {
					System.out.println("Incorrect guess");
					wrong += letter + " ";
				}
			}
		}
		System.out.println("Success! Word was "+word);
		guessAgaing();
		}
	
	public static void printGuess(char[] letters) {
		System.out.print("Guessed: ");
		for(char c: letters) {
			System.out.print(c+ " ");
		}
		System.out.println();
	}
	
	// * -- loop to keep playing upon user request
	public static void guessAgaing() {
		System.out.print("Would you like to Play again:");
		System.out.print("Please put Y for yes or N for no:");
		String Answer = scan.nextLine().toLowerCase();
		if (Answer.equals("y")) {
			guess(getWord());
		}
		else 
			System.out.print("See You Again");
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