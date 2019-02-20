package ioGame;

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

	static String path = "src/ioGame/words.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static String scorePath = "src/ioGame/scoreBoard.txt";

	static String getWord() {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				words.add(line);
				line = br.readLine();
			}
			int randomIndex = (int) (Math.random() * words.size());
			return words.get(randomIndex);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	static void guess(String word) {
		int lives = 6;
		char[] guessed = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";

		while (!String.valueOf(guessed).equals(word) && lives>0) {			
			// print state of guessed
			printGuess(guessed);

			// use scanner to accept next input from user
			System.out.println("Lives: "+lives);
			System.out.println("Guess a letter: ");
			if (wrong != "") {
				System.out.println("Wrong guesses: " + wrong);
			} else {
				System.out.println();
			}
			String letter = scan.nextLine().toLowerCase();//makes input case insensitive
			
			//input validation to receive only letters, repeats until valid input is entered
			while(!letter.matches("[a-z]")) {
				System.out.println("Invalid input");
				System.out.println("Guess a letter: ");
				letter = scan.nextLine().toLowerCase();
			}
			
			if (wrong.contains(letter)) {
				System.out.println("Guessed already");
			} else {
				// match input in word, if present then add to guessed in the proper location
				if (word.contains(letter)) {
					for (int i = 0; i < word.length(); i++) {
						if (word.charAt(i) == letter.charAt(0)) {
							guessed[i] = letter.charAt(0);
						}
					}
				} else {
					System.out.println("Incorrect guess");
					wrong += letter + " ";
					lives--;
				}

			}
		}
		if(lives == 0) {
			System.out.println("You lose");
			writeToScoreBoard(word, guessed, wrong);
		}
		else {
			System.out.println("Success: word was " + word);
			writeToScoreBoard(word, guessed, wrong);
		}
	}

	public static void printGuess(char[] letters) {
		System.out.print("Guessed: ");
		for (char c : letters) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
	//writes the word to be guessed, user's guesses so far, and the list of wrong attempts to
	//file scoreBoard.txt
	public static void writeToScoreBoard(String word, char[] guessed, String wrong) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(scorePath))){
			
			bw.append("Word: "+word);
			bw.append("\nGuessed: ");
			for(char c:guessed) {
				bw.append(c);
			}
			bw.append("\nWrong guesses: "+wrong);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Java hangman: ");
		String input = "n";
		//do while loop will allow player to play again as many times as they like. 
		do {
			guess(getWord());
			System.out.println("Play again?");
			input = scan.nextLine().toLowerCase();
		}while(input.equals("y"));
		System.out.println("Goodbye");
	}

}
