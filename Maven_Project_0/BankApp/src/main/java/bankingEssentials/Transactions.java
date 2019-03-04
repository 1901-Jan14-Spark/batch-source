package bankingEssentials;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Transactions{
	public final static Logger log = Logger.getRootLogger();
	static String path= "src/main/java/bankingEssentials/BankData.txt/";
	static Scanner input = new Scanner(System.in);
	static List<String> content = new ArrayList<>();

	public static void readerWrite() {
		try(BufferedReader br = new BufferedReader(new FileReader(path));){
			String line = br.readLine();
			while(line != null) {
				content.add(line);
				line = br.readLine();
				}		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void makeNew() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path));){
			log.info("WELCOME NEW MEMBER");
			
			log.info("Please Enter New Username: ");
			System.out.println();
			String username = input.nextLine();
			content.add(username);	
			
			log.info("Please Enter New Password: ");
			System.out.println();
			String password = input.nextLine();
			content.add(password);	
			
			userName();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void userName() {
		log.info("Please Enter Username: ");
		log.info(" ");
		String username = input.nextLine();
		String temp = "" +content.get(0);
		while(username.equals(temp)== false) {
			log.error(" INVALID USERNAME, PLEASE TRY AGAIN");
			userName();
		}
		 if(username .equals(temp)==true) {
			passWord();
		}
		
	}
	
	public static void passWord() {
		log.info("Please Enter Password: ");
		String password = input.nextLine();
		String temp = "" +content.get(1);
		if(password.equals(temp) == false) {
			log.error("INVALID PASSWORD, PLEASE TRY AGAIN");
			passWord();
			}
		else if(password.equals(temp) == true) {
			log.info("LOGIN SUCCESS");
		}
	}

	
	
	public static void main(String[] args) {
		readerWrite();
		makeNew();
		
	}
	
}
