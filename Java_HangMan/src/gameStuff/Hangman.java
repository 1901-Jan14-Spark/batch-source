package gameStuff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

	
/*
 * Add rules to game:
 *  input validation
 * -- limit to 6 incorrect guesses
 * -- loop to keep playing upon user request
 * -- case insensitive
 * -- write to a scoreboard
 * -- theme game / separate by difficulty (optional)
 * 
 */


public class Hangman {
	static String wordsFilePath = "src/gameStuff/words.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	private static Scanner play;
	
	public static void startHangman() {
		System.out.println("Welcome to Java Hangman.");
		guess(getWord());
	}
	public  static void restartHangman() {
		play = new Scanner(System.in);
		System.out.println("Would You Like To Play Hangman? Please Enter 'true' or 'false;");
		boolean userWantsToPlay = play.nextBoolean();
		if(userWantsToPlay == true) {
			startHangman();
		}else{
			System.out.println("Thank YOu For Playing");
		}
	}
	public static void main(String[] args) {
		restartHangman();
	}
	
	
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
			if(wrong.length() >= 12) {
				System.out.println("You Been Hanged ^ ^ ");
				restartHangman();
			}
			} else {
				System.out.println();
			}
			System.out.println(wrong.length());
			//(New Comment) this should clear up any problems with capitals or lower case
			String letter = scan.nextLine().toLowerCase();
			
			
			if(wrong.contains(letter)) {
				System.out.println("Guessed already!");}
			/*(New Comment) I believe this filters out just about anything that is not a letter,
			*additionally I think it accounts for attempts at multiple inputs (still trying to learn regex);
			**/	
			else if
					 (!letter.matches("[a-zA-Z]")) {
					     System.out.println("Invalid Input Please Enter a single letter form Aa-Zz");				
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