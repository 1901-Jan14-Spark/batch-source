package com.revature.io.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GameDriver {

	static ArrayList<String> wordBank = new ArrayList<String>();
	static String path = "src/com/revature/io/game/words.txt";
	static String pathLead = "src/com/revature/io/game/leaderboard.txt";
	static Scanner sc = new Scanner(System.in);
	static char[] guessed;
	static HashSet<String> wrongLetter = new HashSet<String>();
	static int counter = 0;

	public static void main(String[] args) {
		System.out.println("Welcome to Hangman.\nYou can have up to 6 incorrect guesses to guess a word!");
		populateWordBank();
		guess(getRandomWord());
		putToLeaderboard();
		keepPlaying();

	}

	public static void resetGame() {
		for (int i = 0; i < 10; i++) {
			System.out.println("\n");
		}
		wordBank = new ArrayList<String>();
		wrongLetter = new HashSet<String>();
	}

	public static void printGuess() {
		for (char c : guessed) {
			System.out.print(c + " ");
		}
	}

	public static void guess(String word) {
		guessed = new char[word.length()];

		for (int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}

		while (!String.copyValueOf(guessed).contentEquals(word)) {

			if (wrongLetter.size() > 6) {
				break;
			}
			printMessage();
			String letter = sc.nextLine().toLowerCase();
			if (!isCorrectInput(letter)) {
				System.out.println("Incorrect input.\n");
				continue;
			}
			if (word.contains(letter)) {
				counter++;
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == letter.charAt(0)) {
						guessed[i] = letter.charAt(0);
					}
				}
			} else {
				if (wrongLetter.contains(letter) == true) {
					System.out.println("Letter already present.\n");
				} else {
					wrongLetter.add(letter);
					counter++;
				}

			}
		}
		if (wrongLetter.size() > 6) {
			System.out.println("\nYou lost. The word was " + word);
		} else {
			System.out.println("\nSuccess! The word was " + word + ", number of tries: " + counter);
		}

	}

	public static boolean isCorrectInput(String string) {
		if (string.length() > 1 || string.replaceAll("[^a-z]", "") != string) {
			return false;
		}
		return true;
	}

	public static void populateWordBank() {
		try (BufferedReader br = new BufferedReader(new FileReader(path));) {
			while (br.readLine() != null) {
				wordBank.add(br.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getRandomWord() {
		return wordBank.get((int) (Math.random() * wordBank.size()));
	}

	public static void keepPlaying() {
		System.out.println("Press y to play again.");
		String restartGame = sc.nextLine().toLowerCase();
		System.out.println(restartGame);
		if (restartGame.equals("y")) {
			resetGame();
			main(null);
		}
	}

	public static void printMessage() {
		System.out.println();
		printGuess();
		System.out.println("\nPlease enter a letter:");
		System.out.print("Error count: " + wrongLetter.size() + ". Wrong letters are: ");
		for (String s : wrongLetter) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	public static void putToLeaderboard() {
		System.out.println("Please enter a username.");
		String username = sc.nextLine();

		String content = "User: " + username + "\tTries:" + counter + "\tWrong guesses: " + wrongLetter.size();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathLead,true));) {

			bw.newLine();
			bw.append(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
