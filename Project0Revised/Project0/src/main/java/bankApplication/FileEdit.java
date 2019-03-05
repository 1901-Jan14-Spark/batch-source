package bankApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileEdit {
	static String userFilePath = "src/storage/Users.txt";
	static String accBalFilePath = "src/storage/AccountBalance.txt";
	private static Logger log = Logger.getRootLogger();
	
	//overwrite user's new balance
	public static boolean adjustBalance(String userName, double amount, char operation) {
		//read in current user balance
		double currBal = Double.parseDouble(readBalance(userName));
		if(operation == 'd') {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(accBalFilePath))){
				
				double newBal = currBal + amount;
				bw.append(userName).append(" "+newBal);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		else if(operation == 'w') {
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(accBalFilePath))){
				
				double newBal = currBal - amount;
				bw.append(userName).append(" "+newBal);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	//read in users balance
	public static String readBalance(String userName) {
		String output = "error";
		try(BufferedReader br = new BufferedReader(new FileReader(accBalFilePath))){
			
			String line = br.readLine();
			while(line != null) {
				if(line.contains(userName)) {
					output = line.replaceAll("[a-z\\s]", "");//remove all characters except for numbers;
				}
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	//confirm user name and password
	public static boolean confirmLogin(String userName, String password) {
		try(BufferedReader br = new BufferedReader(new FileReader(userFilePath))){
			
			String line = br.readLine();
			while(line != null) {
				if(line.contentEquals(userName+" "+password)) {
					return true;
				}
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//check if user already exists in file
	public static boolean doesUserExist(String userName) {
		try(BufferedReader br = new BufferedReader(new FileReader(userFilePath))){
			
			String line = br.readLine();
			while(line != null) {
				if(line.contains(userName)) {
					return true;
				}
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//write user to users file and create balance of $0 in AccountBalance file
	public static void saveUser(String userName, String password) {
		try(BufferedWriter usersWrite = new BufferedWriter(new FileWriter(userFilePath));
				BufferedWriter accWrite = new BufferedWriter(new FileWriter(accBalFilePath))){
			
			if(doesUserExist(userName))
				log.info("\nUser already exists\n");
			
			else {
				usersWrite.append(userName).append(" "+password);
				accWrite.append(userName).append(" 0");
				log.info("\nUser successfuly saved.\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
