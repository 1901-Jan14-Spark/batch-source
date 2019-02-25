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
	static String wordsFilePath = "words.txt";
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
    int count = 0;

		while(!String.valueOf(guessed).equals(word) && count < 6) {
			// print state of guessed array
			printGuess(guessed);

			// use scanner to get the next input from our user
      System.out.println("Attempt Remaining: " + (6 - count));
			System.out.print("Guess a letter:");
			if(wrong!="") {
				System.out.println("Your previous wrong guesses are: "+wrong);
			} else {
				System.out.println();
			}
      boolean isLetter = false;

      while(!isLetter){
        String letter = scan.nextLine().toLowerCase();

        if(letter.length() > 1){
          System.out.println("Ya goon! You can only guess one letter at a time.");
        } else if(!letter.matches("^[a-z]")){
          System.out.println("Ya hooligan! Only letters are allowed in hangman.");
        }else if(wrong.contains(letter)) {
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
            count++;
  				}
          isLetter = true;
  			}

  		}
    }

		if(count >= 6){
      System.out.println("Better luck next time! Word was "+word);
    } else{
      System.out.println("Success! Word was "+word);
      System.out.println("Name?");
      String name = scan.nextLine();

      String path = "score.txt";
      try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
        bw.append(name + ": " + count + "\n");
        bw.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }

    System.out.println("Continue to play? (y/n)");
    String play = scan.nextLine().toLowerCase();
    if(play.equals("y") || play.equals("yes")) guess(getWord());
    else System.out.println("See ya later Alligator!");

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
