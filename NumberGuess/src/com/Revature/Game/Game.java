package com.Revature.Game;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Game {
	public static void main(String[] args) {
	
		
		
		play();
	}
	
	
	
	
	public static void play() {
		Scanner s1=new Scanner(System.in);
		double number =Math.floor(Math.random()*100);
		System.out.println("Guess a number between 1 and 100");
		double guess=0;
	try {	
	  guess=s1.nextDouble();
	}catch(InputMismatchException ex) {
		 System.out.println("Input a number between 1 and 100");
	}
		  boolean won=false;
		  double highGuess=100;
		  double lowGuess=0;
	 int counter=0;
	 
		  while(won==false) {
			  counter++;
		if ( guess==number) {
			won=true;
			System.out.println("You won, it only took " + counter+ " guesses.");
		}
		else if(guess>number) {
			won=false;
			if (guess<highGuess) {
			highGuess=guess;
					System.out.println("Too high, guess a number between "+ highGuess + " and "+ lowGuess);
					 guess=s1.nextDouble();}
			else {guess=s1.nextDouble();
			System.out.println("Try again");
			}
					 
					 
		}
		else if(guess<number) {
			won=false;
			if(guess>lowGuess) {
			lowGuess=guess;
					System.out.println("You guessed too low, guess a number between "+ lowGuess + " and "+highGuess);
					 guess=s1.nextDouble();
			}else {guess=s1.nextDouble();
			System.out.println("Try again");
			}
		
		}
		
	}
	 
	 }
	
	 
	 
	 
	}


