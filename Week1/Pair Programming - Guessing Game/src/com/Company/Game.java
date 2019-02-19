package com.Company;

import com.Company.Exception.NumberOutOfRangeException;

import java.util.Scanner;

public class Game {

    static Scanner sc = new Scanner(System.in);



    public static void play () {
        System.out.println("Please enter a number between 0 to 100: ");
        int guessNum = Integer.parseInt(sc.nextLine());
        int n1 = (int) (Math.random() * 100 + 1 );
        int low = 0;
        int high = 100;
        int guessCount = 0;
        while(guessNum != n1) {
//            if (guessNum < 0 || guessNum > 100) {
//                throw new NumberOutOfRangeException("Number between 0 to 100");

//            } else {

                if (guessNum > n1 || guessNum > high) {

                    try {
                        if(guessNum < high) {
                            high = guessNum;
                        }
                        System.out.println("Too High");
                        System.out.println("Please enter a number between " + low + " to " + high);
                        guessNum = Integer.parseInt(sc.nextLine());
                        guessCount++;

                    } catch (NumberFormatException e) {
                        System.out.println("Need to be an integer number, please guess again");
                        guessNum = Integer.parseInt(sc.nextLine());
                    }
                } else {
                    try {
                        if(guessNum > low) {
                            low = guessNum;
                        }
                        low = guessNum;
                        System.out.println("Too low");
                        System.out.println("Please enter a number between " + low + " to " + high);
                        guessNum = Integer.parseInt(sc.nextLine());
                        guessCount++;

                    } catch (NumberFormatException e) {
                        System.out.println("Need to be an integer number, please guess again");
                        guessNum = Integer.parseInt(sc.nextLine());
                    }
                }


        }
        System.out.println("The num was " + n1 + " and you guessed correctly!");
        System.out.println("Guess count: " + guessCount);
    }

    public static void main(String[] args) {
        play();
    }


}
