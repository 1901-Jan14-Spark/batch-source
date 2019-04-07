package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
	static String wordsFilePath = "src/Game/words.txt";
	static ArrayList<String> words = new ArrayList<>();	
	static Scanner scan = new Scanner (System.in);
	static Scanner cont = new Scanner (System.in);
	static String[] bads = {"1","2","3","4","5","6","7","8","9","0","[","."," "};
	static String conv= Arrays.toString(bads);
	public static int tries = 6;
	static String path = "src/Game/score.txt";
public static void main(String[] args) {
	System.out.println("Welcome To Hangman");
	guess(getWord(),tries);
}

static void guess(String word, int tries) {
	
	if(tries >=0) {
	char[] guessed = new char[word.length()];
	for(int i = 0; i <word.length(); i++) {
		guessed[i] = '_';
	}
	
	String wrong = "";
	
	while(!String.valueOf(guessed).equals(word)) {
		while(tries>0) {
		printGuess(guessed);
		//System.out.println(tries);
		
		// use scanner to get the next input from our user
		System.out.println("Guess a letter: ");
		if(wrong!="") {
			System.out.println("Your previous wrong guesses are: " +wrong);
		}else {
			System.out.println();
		}
		String letter = scan.nextLine();
		letter = letter.toLowerCase();
		
		if(conv.contains(letter)){
			System.out.println("Enter a LETTER!");
			
		}
		if(wrong.contains(letter)) {
			System.out.println("You Guessed that Already dude");
		}else {
			if(word.contains(letter)) {
				for(int i=0; i<word.length();i++) {
					if(word.charAt(i)==letter.charAt(0)) {
					guessed[i] = word.charAt(i);
					
				}
			}
		}else {
			tries -= 1;
			System.out.println("inccoret. Also, you only have like, " +tries+" tries left");
			wrong += letter + " ";
			if(tries<=0) {
//				System.out.println("Lets play again");
				for(int i=0; i<word.length();i++) {
					guessed[i] = word.charAt(i);
				}
				
			}
			
			
		} 
		}
			} {
				System.out.println("You lost");
//				System.out.println("Would you like to Play agian?");
//				String ans = cont.nextLine();
//				if(ans == "yes") {
//				guess(getWord(),tries+6);
				}
				break;
				
				
			}
	}System.out.println("You're Done. The word was"+word+". With "+tries+ " tries Left.");
	
	try(FileWriter fw = new FileWriter(path); BufferedWriter bw = new BufferedWriter(fw)){
		bw.append(Integer.toString(tries)+"\n").append(Integer.toString(tries)+"\n");
		System.out.println("Score has been sent");
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	
	
	System.out.println("Would you like to Play agian? Type yes if you do.");
	System.out.println();
	
	String ans = cont.nextLine();
	if(ans.equals("yes")) {
	guess(getWord(),tries+6);
	}
}	
	//}
	//}
	

	
		
	


public static void printGuess(char[] letters) {
	System.out.println("Guessed: ");
	for(char c : letters) {
		System.out.print(c+" ");
		
	}
	System.out.println();
}

//getWord method returns a random word from words


static String getWord() {
	try(BufferedReader br = new BufferedReader(new FileReader(wordsFilePath))){
		String line = br.readLine();
		while(line!=null){
			words.add(line);
			line =br.readLine();
		}
		
		int randomIndex = (int)(Math.random()*words.size());
		return words.get(randomIndex);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}


}
