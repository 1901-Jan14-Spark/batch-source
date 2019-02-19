package com.revature.thegame;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.NotInRangeException;

public class Game {

	static Scanner input = new Scanner(System.in);
	static int guessThis = (int) Math.round(Math.random()*100000);
	static int low = 0;
	static int high = 100000;
	static int guessCount = 0;
	
	public static void play(){
		System.out.println("Welcome to the number guessing game! Input any number from "+low+"-"+high+" to begin guessing.");
		int playerGuess = 100001;
		while (playerGuess != guessThis) 
		{
			try 
			{
				playerGuess = input.nextInt();
				if(playerGuess < 0 || playerGuess > 100000) 
				{
					throw new NotInRangeException();
				}
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Hey dude, you can only put whole numbers in here!");
				input.nextLine();
				continue;
			}
			catch (NotInRangeException e) 
			{
				System.out.println("Dude, your numbers can't be less than 0 or greater than 100. Try again");
				continue;
			}
			
			if (playerGuess > high || playerGuess < low) 
			{
				System.out.println("Dude, you can't choose a number that's not in range of "+low+" and "+high+". Guess again.");
				continue;
			}
			
			guessCount++;
			if(playerGuess > guessThis)
			{
				high = playerGuess;
				System.out.println("Your guess is too high, guess again between "+low+" and "+high);
				
			} 	
			else if(playerGuess < guessThis) 
			{
				if (playerGuess > low) 
				{
					low = playerGuess;
					System.out.println("Your guess is too low, guess again between "+low+" and "+high);
				}
			}
	
		}	
		System.out.println("Your number was "+guessThis+", it took you "+guessCount+" tries to get this correct!");
	}
	
	public static void main(String[] args) 
	{
		play();
	}
}
