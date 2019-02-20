import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
	
/* ! == done
 * Add rules to game:
 * -- input validation !
 * -- limit to 6 incorrect guesses !
 * -- loop to keep playing upon user request !
 * -- case insensitive !
 * -- write to a scoreboard
 * -- theme game / separate by difficulty (optional)
 * 
 */


public class Hangman {
	static String wordsFilePath = "words.txt";
	static ArrayList<String> words = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
        System.out.println("Welcome to Java Hangman.");
        boolean firstTime = true;
        while(true){
            if(!firstTime){
            System.out.println("Would you like to play again? [y/n]");
            String playagain = scan.nextLine();
            playagain.toLowerCase();
            if((playagain.charAt(0)!='y'|| playagain.charAt(0)!='n')){//input validation for the would you like to continue
                System.out.println("Enter y or n! (Yes or no)");
                continue;
            }
            if(playagain.charAt(0)=='n')
                break;
            }
            guess(getWord());
            firstTime= false;
        }
	}
	
	
	static void guess(String word) {
		char[] guessed = new char[word.length()];
		for(int i = 0; i<word.length(); i++) {
			guessed[i] = '_';
		}
		String wrong = "";
		
		while(!String.valueOf(guessed).equals(word) && (wrong.length()<12)) {//limiting to 6
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
            letter = letter.toLowerCase();
            if(letter.length()>1 && ('a'<=letter.charAt(0)&& letter.charAt(0)<='z')){
                System.out.println("Only a single character will be accepted"); //input validation
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

		}
        if(wrong.length()<12){//win condition based on if they lost or not
            writeScore("Win! Word: "+word+" Number of wrong guesses:"+(wrong.length()/2));
            System.out.println("Success! Word was "+word);
        }
        else{
            String fguessed="";
            for(char c: guessed)
                fguessed+= c+" ";
            writeScore("Loss! Word: "+word+" Final state of word: "+ fguessed);
            System.out.println("Better luck next time, word was "+word);
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
	static void writeScore(String score){
        try{
            BufferedReader br = new BufferedReader(new FileReader("scoreboard.txt"));
            String oldStuff = "";
            String line = br.readLine();
            while(line!=null) {
                oldStuff+=line+"\n";
                line = br.readLine();
                }
            PrintWriter pw =new PrintWriter( new BufferedWriter(new FileWriter("scoreboard.txt")));// this line on is my original code
            pw.println(oldStuff+score);
            pw.flush();
            pw.close();
            br.close();
        }catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
//	public static void clearConsole() {
//		for(int i = 0; i<20; i++) {
//			System.out.println();
//		}
//	}